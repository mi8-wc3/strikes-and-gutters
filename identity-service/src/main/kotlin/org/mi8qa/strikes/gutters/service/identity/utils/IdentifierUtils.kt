package org.mi8qa.strikes.gutters.service.identity.utils

import java.nio.ByteBuffer
import java.security.MessageDigest
import java.security.SecureRandom
import java.util.concurrent.atomic.AtomicInteger
import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

class IdentifierUtils {


    /**
     * Generate CUID with a length constraint of up to 50 characters.
     * @return generated CUID string
     */
    companion object {

        private val seedGenerator = SecureRandom()
        private val counter = AtomicInteger(seedGenerator.nextInt())
        fun generateCUID(): String {
            val stringBuilder = StringBuilder()

            stringBuilder.append(generatePrefix())
            stringBuilder.append(generateTimestamp())
            stringBuilder.append(generatePID())
            stringBuilder.append(generateCounter())

            val randomData = generateRandomData()
            stringBuilder.append(applySHA256(randomData))

            val randomKey = generateRandomKey()
            stringBuilder.append(applyAES256(randomData, randomKey))

            return truncateToLength(stringBuilder, 50)
        }

        private fun generatePrefix(): String {
            return "c"
        }

        private fun generateTimestamp(): String {
            return System.currentTimeMillis().toString(36)
        }

        private fun generatePID(): String {
            return seedGenerator.nextInt().toString(36)
        }

        private fun generateCounter(): String {
            return counter.getAndIncrement().toString(36)
        }

        private fun generateRandomData(): ByteBuffer {
            val randomData = ByteBuffer.allocate(24)
            val nanoTime = System.nanoTime()
            val threadId = seedGenerator.nextLong()
            randomData.putLong(nanoTime xor threadId)
            randomData.putInt(counter.get())
            return randomData
        }

        private fun applySHA256(data: ByteBuffer): String {
            val messageDigest = MessageDigest.getInstance("SHA-256")
            messageDigest.update(data.array())
            val hash = messageDigest.digest()
            return hash.joinToString("") { String.format("%02x", it) }
        }

        private fun generateRandomKey(): String {
            val keyBytes = ByteArray(32)
            seedGenerator.nextBytes(keyBytes)
            return keyBytes.joinToString("") { String.format("%02x", it) }
        }

        private fun applyAES256(data: ByteBuffer, key: String): String {
            val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
            val secretKey = SecretKeySpec(key.toByteArray(), "AES")
            cipher.init(Cipher.ENCRYPT_MODE, secretKey)
            val encryptedData = cipher.doFinal(data.array())
            return encryptedData.joinToString("") { String.format("%02x", it) }
        }

        private fun truncateToLength(stringBuilder: StringBuilder, maxLength: Int): String {
            if (stringBuilder.length > maxLength) {
                return stringBuilder.substring(0, maxLength)
            }
            return stringBuilder.toString()
        }
    }
}
