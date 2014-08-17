package co.fusionx.relay.parser.command;

import com.google.common.base.Optional;

import java.util.Collection;
import java.util.List;

import co.fusionx.relay.ChannelUser;
import co.fusionx.relay.RelayChannel;
import co.fusionx.relay.RelayChannelUser;
import co.fusionx.relay.RelayServer;
import co.fusionx.relay.event.channel.ChannelWorldPartEvent;
import co.fusionx.relay.event.channel.ChannelWorldUserEvent;
import co.fusionx.relay.event.channel.PartEvent;
import co.fusionx.relay.util.IRCUtils;

public class PartParser extends RemoveUserParser {

    public PartParser(final RelayServer server) {
        super(server);
    }

    @Override
    public Optional<RelayChannelUser> getRemovedUser(final List<String> parsedArray,
            final String rawSource) {
        final String userNick = IRCUtils.getNickFromRaw(rawSource);
        return mUserChannelInterface.getUser(userNick);
    }

    @Override
    public ChannelWorldUserEvent getEvent(final List<String> parsedArray, final String rawSource,
            final RelayChannel channel, final ChannelUser user) {
        final String reason = parsedArray.size() == 4 ? parsedArray.get(3).replace("\"", "") : "";
        return new ChannelWorldPartEvent(channel, user, reason);
    }

    @Override
    void onRemoved(final List<String> parsedArray, final String rawSource,
            final RelayChannel channel) {
        // ZNCs can be stupid and can sometimes send PART commands for channels they didn't send
        // JOIN commands for...
        if (channel == null) {
            return;
        }

        final Collection<RelayChannelUser> users = mUserChannelInterface.removeChannel(channel);
        for (final RelayChannelUser user : users) {
            mUserChannelInterface.removeChannelFromUser(channel, user);
        }
        channel.postAndStoreEvent(new PartEvent(channel));
    }
}