package com.dankai.latte.delegates.web.event;
/*
 *  项目名:    FastEC
 *  包名：     com.dankai.latte.delegates.web.event
 *  文件名:    EventManager
 *  创建者:    WK
 *  时间：     2019/8/3 9:18
 *  描述：     TODO
 */

import androidx.annotation.NonNull;

import java.util.HashMap;

public class EventManager {

    private static final HashMap<String, Event> EVENTS = new HashMap<>();

    private EventManager() {

    }

    private static class Holder {
        private static final EventManager INSTANCE = new EventManager();
    }

    public static EventManager getInstance() {
        return Holder.INSTANCE;
    }

    public EventManager addEvent(@NonNull String name,@NonNull Event event) {
        EVENTS.put(name, event);
        return this;
    }

    public Event createEvent(@NonNull String action) {
        final Event event = EVENTS.get(action);
        if (event == null) {
            return new UndefinedEvent();
        }
        return event;
    }

}
