package com.mercadona.rrhh.evaluation.config;

import com.mercadona.rrhh.evaluation.interceptors.LocaleInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Locale config for setting in {@link LocaleContextHolder} the locale
 *
 * <p>Internally it takes the locale from request param. If it isn't included it sets spanish as default</p>
 *
 * @author Mercadona
 * @version February 2025
 * @since 0.1.2
 */
@Configuration
public class LocaleConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new LocaleInterceptor());
  }
}
