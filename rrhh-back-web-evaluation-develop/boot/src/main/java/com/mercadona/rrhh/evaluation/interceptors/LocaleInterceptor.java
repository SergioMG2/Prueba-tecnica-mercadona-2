package com.mercadona.rrhh.evaluation.interceptors;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpHeaders;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class LocaleInterceptor implements HandlerInterceptor {

  private static final String LOCALE_LANGUAGE_STARTS_EN = "en-";
  private static final String DEFAULT_LOCALE = "es-ES";
  private static final String LOCALE_PT = "pt-PT";
  private static final Locale DEFAULT_LOCALE_TAG = Locale.forLanguageTag(DEFAULT_LOCALE);
  private static final String LOCALE_PARAM = "localeLanguage";

  private static final List<Locale> SUPPORTED_LOCALES = Arrays.asList(
    Locale.UK,
    Locale.forLanguageTag(DEFAULT_LOCALE),
    Locale.forLanguageTag(LOCALE_PT)
  );

  @Bean
  public LocaleResolver localResolver() {
    var acceptLocaleResolver = new AcceptHeaderLocaleResolver();
    acceptLocaleResolver.setSupportedLocales(SUPPORTED_LOCALES);
    acceptLocaleResolver.setDefaultLocale(DEFAULT_LOCALE_TAG);

    return acceptLocaleResolver;
  }

  @Override
  public boolean preHandle(HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) {
    String localeQuery = request.getParameter(LOCALE_PARAM);
    String localeHeader = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);

    Locale resolvedLocale = localResolver().resolveLocale(request);
    String languageTag = resolvedLocale.toLanguageTag();
    languageTag = (localeQuery != null && !localeQuery.isEmpty()) ? localeQuery : languageTag;
    Locale calculatedLocale = unifyEnglishLocale(Locale.forLanguageTag(languageTag), localeQuery != null ? localeQuery : localeHeader);

    log.info("Setting locale for request {}", calculatedLocale);
    LocaleContextHolder.setLocale(calculatedLocale, true);

    return true;
  }

  private Locale unifyEnglishLocale(Locale calculatedLocale, String locale) {
    if (locale != null && locale.startsWith(LOCALE_LANGUAGE_STARTS_EN)) {
      return Locale.forLanguageTag(Locale.UK.toLanguageTag());
    }

    return calculatedLocale;
  }
}
