package com.nivedita.sunshine.di.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * This defines scope for an individual activity
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface PerActivity {
}
