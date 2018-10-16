package com.github.rkonovalov.logger;

import org.apache.log4j.Level;

public class EventQueueItem {
    private LoggerEvent event;
    private Level level;
    private PacketType packetType;
    private Object eventResult;

    public EventQueueItem(LoggerEvent event, Level level, PacketType packetType) {
        this.event = event;
        this.level = level;
        this.packetType = packetType;

        if(packetType == PacketType.NOT_CRITICAL)
            this.eventResult = event.onEvent();
    }

    public LoggerEvent getEvent() {
        return event;
    }

    public Level getLevel() {
        return level;
    }

    public PacketType getPacketType() {
        return packetType;
    }

    public Object getEventResult() {
        return eventResult;
    }
}
