/*
 * Copyright 2012 The Netty Project
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package io.netty.channel;

/**
 * {@link ChannelHandler} which adds callbacks for state changes. This allows the user
 * to hook in to state changes easily.
 *
 * 处理入站数据以及各种状态变化
 * 响应的数据的接口
 */
public interface ChannelInboundHandler extends ChannelHandler {

//    ----------------------------life cycle------------------------------------

    /**
     * The {@link Channel} of the {@link ChannelHandlerContext}
     * was registered with its {@link EventLoop}
     */
    void channelRegistered(ChannelHandlerContext ctx) throws Exception;

    /**
     * The {@link Channel} of the {@link ChannelHandlerContext} was
     * unregistered from its {@link EventLoop}
     */
    void channelUnregistered(ChannelHandlerContext ctx) throws Exception;

    /**
     * The {@link Channel} of the {@link ChannelHandlerContext} is now active
     */
    void channelActive(ChannelHandlerContext ctx) throws Exception;

    /**
     * The {@link Channel} of the {@link ChannelHandlerContext} was registered is now inactive and reached its
     * end of lifetime.
     *
     * 不再连接它的远程节点时候
     */
    void channelInactive(ChannelHandlerContext ctx) throws Exception;

    /**
     * Invoked when the current {@link Channel} has read a message from the peer.
     */
    void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception;

    /**
     * Invoked when the last message read by the current read operation has been consumed by
     * {@link #channelRead(ChannelHandlerContext, Object)}.  If {@link ChannelOption#AUTO_READ} is off, no further
     * attempt to read an inbound data from the current {@link Channel} will be made until
     * {@link ChannelHandlerContext#read()} is called.
     *
     * 当上一个读操作完成时被调用，在它调用之前channelRead()可能会被多次调用
     */
    void channelReadComplete(ChannelHandlerContext ctx) throws Exception;

    /**
     * Gets called if an user event was triggered.
     * 当ChannelInboundInvoker.fireUserEventTriggered()方法调用时被调用，因为一个Pojo已经被传进ChannelPipeline了
     */
    void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception;

    /**
     * Gets called once the writable state of a {@link Channel} changed. You can check the state with
     * {@link Channel#isWritable()}.
     * 当Channel的可写状态改变时调用
     */
    void channelWritabilityChanged(ChannelHandlerContext ctx) throws Exception;

//    ----------------------------------------------------------------

    /**
     * Gets called if a {@link Throwable} was thrown.
     */
    @Override
    @SuppressWarnings("deprecation")
    void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception;
}
