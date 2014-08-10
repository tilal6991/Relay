package com.fusionx.relay.event.channel;

import com.fusionx.relay.Channel;
import com.fusionx.relay.ChannelUser;
import com.fusionx.relay.Nick;

import java8.util.Optional;

public class ChannelModeEvent extends ChannelEvent {

    public final String recipient;

    public final Optional<? extends ChannelUser> sendingUser;

    public final String sendingNick;

    public final String mode;

    public ChannelModeEvent(final Channel channel,
            final Optional<? extends ChannelUser> sendingUser, final String sendingNick,
            final String recipient, final String mode) {
        super(channel);

        this.recipient = recipient;
        this.sendingUser = sendingUser;
        this.sendingNick = sendingNick;
        this.mode = mode;
    }
}