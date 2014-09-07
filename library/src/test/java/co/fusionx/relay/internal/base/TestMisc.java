package co.fusionx.relay.internal.base;

import co.fusionx.relay.base.Server;
import co.fusionx.relay.interfaces.RelayConfiguration;

public class TestMisc {

    public static class DefaultRelayConfiguration implements RelayConfiguration {

        @Override
        public int getReconnectAttemptsCount() {
            return 0;
        }

        @Override
        public String getPartReason() {
            return null;
        }

        @Override
        public String getQuitReason() {
            return null;
        }

        @Override
        public boolean isSelfEventHidden() {
            return true;
        }

        @Override
        public boolean isMOTDShown() {
            return false;
        }

        @Override
        public void logMissingData(final Server server) {

        }

        @Override
        public void logServerLine(final String line) {

        }

        @Override
        public void handleException(final Exception ex) {

        }
    }
}