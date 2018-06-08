package com.jesuslcorominas.blank.data.di.module;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.jesuslcorominas.blank.commons.utils.DateUtils;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import java.lang.reflect.Type;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Jesus Lopez Corominas on 08/06/2018.
 */
@Module
public class GsonModule {

    @Singleton
    @Provides
    Gson provideGson(JsonSerializer<DateTime> dateTimeJsonSerializer,
                     JsonDeserializer<DateTime> dateTimeJsonDeserializer,
                     JsonSerializer<Boolean> booleanJsonSerializer,
                     JsonDeserializer<Boolean> booleanJsonDeserializer) {
        return new GsonBuilder().
                setPrettyPrinting().
                registerTypeAdapter(DateTime.class, dateTimeJsonDeserializer).
                registerTypeAdapter(DateTime.class, dateTimeJsonSerializer).
                registerTypeAdapter(Boolean.class, booleanJsonDeserializer).
                registerTypeAdapter(Boolean.class, booleanJsonSerializer).
                create();
    }

    @Singleton
    @Provides
    JsonSerializer<DateTime> provideDateTimeJsonSerializer() {
        return new JsonSerializer<DateTime>() {
            @Override
            public JsonElement serialize(DateTime src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src.toString(DateUtils.DATE_TIME_FORMAT));
            }
        };
    }

    @Singleton
    @Provides
    JsonDeserializer<DateTime> provideDateTimeJsonDeserializer() {
        return new JsonDeserializer<DateTime>() {
            @Override
            public DateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                if (json.getAsJsonPrimitive().isNumber()) {
                    return new DateTime(json.getAsLong());
                }

                return DateTime.parse(json.getAsString(), DateTimeFormat.forPattern(DateUtils.DATE_TIME_FORMAT));
            }
        };
    }


    @Singleton
    @Provides
    JsonSerializer<Boolean> provideBooleanJsonSerializer() {
        return new JsonSerializer<Boolean>() {
            @Override
            public JsonElement serialize(Boolean src, Type typeOfSrc, JsonSerializationContext context) {
                return new JsonPrimitive(src ? 1 : 0);
            }
        };
    }

    @Singleton
    @Provides
    JsonDeserializer<Boolean> provideBooleanJsonDeserializer() {
        return new JsonDeserializer<Boolean>() {
            @Override
            public Boolean deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
                if (json.getAsJsonPrimitive().isBoolean()) {
                    return json.getAsBoolean();
                }

                return json.getAsInt() == 1;
            }
        };
    }
}
