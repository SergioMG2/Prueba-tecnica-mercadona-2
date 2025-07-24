package com.mercadona.rrhh.evaluation.application.messages;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MessageService {

    private final MessageSource messageSourceError;

    public String generateMessageByLocale(@NonNull String messageProperty) {
        return getSingleMessage(messageProperty);
    }

    public String generateArgumentMessageByLocale(@NonNull String messageProperty, @NonNull String[] messageArguments) {
        return getArgumentsMessage(messageProperty, messageArguments);
    }

    private String getSingleMessage(String messageProperty) {
        MessageSourceResolvable messageSourceResolvable = new DefaultMessageSourceResolvable(messageProperty);
        return this.messageSourceError.getMessage(messageSourceResolvable, LocaleContextHolder.getLocale());
    }

    private String getArgumentsMessage(String messageProperty, String[] messageArguments) {
        return this.messageSourceError.getMessage(messageProperty, messageArguments, LocaleContextHolder.getLocale());
    }
}
