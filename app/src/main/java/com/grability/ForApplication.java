package com.grability;

import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by rogerp91 on 03/03/17.
 */

@Qualifier
@Retention(RUNTIME)
public @interface ForApplication {
}