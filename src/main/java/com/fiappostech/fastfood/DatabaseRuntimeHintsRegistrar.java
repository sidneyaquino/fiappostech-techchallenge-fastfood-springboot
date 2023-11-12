package com.fiappostech.fastfood;

import org.hibernate.dialect.PostgreSQLDialect;
import org.springframework.aot.hint.MemberCategory;
import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.lang.Nullable;

public class DatabaseRuntimeHintsRegistrar implements RuntimeHintsRegistrar {
    @Override
    public void registerHints(RuntimeHints hints, @Nullable ClassLoader classLoader) {
        hints
                .reflection()
                .registerType(PostgreSQLDialect.class, MemberCategory.values());
    }
}