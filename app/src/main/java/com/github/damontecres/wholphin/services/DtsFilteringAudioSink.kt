package com.github.damontecres.wholphin.services

import androidx.media3.common.Format
import androidx.media3.common.MimeTypes
import androidx.media3.common.util.UnstableApi
import androidx.media3.exoplayer.audio.AudioSink
import androidx.media3.exoplayer.audio.ForwardingAudioSink

@UnstableApi
class DtsFilteringAudioSink(defaultSink: AudioSink) : ForwardingAudioSink(defaultSink) {
    override fun getFormatSupport(format: Format): Int {
        val mimeType = format.sampleMimeType

        if (mimeType == MimeTypes.AUDIO_DTS_HD
            || mimeType == MimeTypes.AUDIO_DTS_EXPRESS
            || mimeType == MimeTypes.AUDIO_DTS_X
        ) {
            return SINK_FORMAT_UNSUPPORTED
        }

        return super.getFormatSupport(format)
    }

    override fun supportsFormat(format: Format): Boolean {
        val mimeType = format.sampleMimeType

        if (mimeType == MimeTypes.AUDIO_DTS ||
            mimeType == MimeTypes.AUDIO_DTS_HD ||
            mimeType == MimeTypes.AUDIO_DTS_EXPRESS
        ) {
            return false
        }

        return super.supportsFormat(format)
    }
}