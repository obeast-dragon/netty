/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 * https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel.udt;

import io.netty.channel.Channel;
import io.netty.channel.udt.nio.NioUdtProvider;

import java.net.InetSocketAddress;

/**
 * UDT {@link Channel}.
 * <p>
 * Supported UDT {@link UdtChannel} are available via {@link NioUdtProvider}.
 *
 * @deprecated The UDT transport is no longer maintained and will be removed.
 *
 *    1.UDT建于UDP之上，并引入新的拥塞控制和数据可靠性控制机制；
 *    2.UDT是面向连接的双向的应用层协议，它同时支持可靠的数据流传输和部分可靠的数据报传输，而UDP是面向无连接不可靠的协议；
 *    位于应用层协议
 */
@Deprecated
public interface UdtChannel extends Channel {

    /**
     * Returns the {@link UdtChannelConfig} of the channel.
     */
    @Override
    UdtChannelConfig config();

    @Override
    InetSocketAddress localAddress();
    @Override
    InetSocketAddress remoteAddress();

}
