package co.fusionx.relay.event.channel;

import com.google.common.base.Optional;

import co.fusionx.relay.base.Channel;
import co.fusionx.relay.base.ChannelUser;
import co.fusionx.relay.constants.UserLevel;

public class ChannelWorldLevelChangeEvent extends ChannelWorldUserEvent {

    public final String rawMode;

    public final Optional<? extends ChannelUser> changingUser;

    public final String changingNick;

    public final UserLevel oldLevel;

    public final UserLevel newLevel;

    public ChannelWorldLevelChangeEvent(final Channel channel, String rawMode,
            final ChannelUser user, final UserLevel oldLevel, final UserLevel newLevel,
            final Optional<? extends ChannelUser> changingUser,
            final String changingNick) {
        super(channel, user);

        this.rawMode = rawMode;
        this.oldLevel = oldLevel;
        this.newLevel = newLevel;
        this.changingUser = changingUser;
        this.changingNick = changingNick;
    }
}