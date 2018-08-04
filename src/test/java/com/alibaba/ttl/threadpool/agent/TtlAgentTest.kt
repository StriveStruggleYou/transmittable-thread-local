package com.alibaba.ttl.threadpool.agent

import com.alibaba.ttl.threadpool.agent.TtlAgent.splitCommaColonStringToKV
import org.junit.Test

import org.junit.Assert.*

class TtlAgentTest {
    @Test
    fun test_splitCommaColonStringToKV() {
        assertEquals(emptyMap<String, String>(), splitCommaColonStringToKV(null))
        assertEquals(emptyMap<String, String>(), splitCommaColonStringToKV(""))
        assertEquals(emptyMap<String, String>(), splitCommaColonStringToKV("   "))

        assertEquals(mapOf("ttl.logger" to "STDOUT"), splitCommaColonStringToKV(
                "ttl.logger:STDOUT"))
        assertEquals(mapOf("k1" to "v1", "ttl.logger" to "STDOUT"), splitCommaColonStringToKV(
                "k1:v1,ttl.logger:STDOUT"))
        assertEquals(mapOf("k1" to "v1", "ttl.logger" to "STDOUT"), splitCommaColonStringToKV(
                "     k1     :v1  , ttl.logger    :STDOUT   "))
    }
}
