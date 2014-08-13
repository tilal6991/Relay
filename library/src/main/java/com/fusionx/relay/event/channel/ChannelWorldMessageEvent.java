package com.fusionx.relay.event.channel;

import com.fusionx.relay.Channel;
import com.fusionx.relay.ChannelUser;

/**
 * Both user and nick can be null
 */
public class ChannelWorldMessageEvent extends ChannelWorldUserEvent {

    public final String message;

    public ChannelWorldMessageEvent(final Channel channel, final String message,
            final ChannelUser sendingUser, final boolean mention) {
        super(channel, sendingUser, mention);

        this.message = message;
    }

    public ChannelWorldMessageEvent(Channel channel, String message, String sendingNick,
            boolean mention) {
        super(channel, sendingNick, mention);

        this.message = message;
    }
}