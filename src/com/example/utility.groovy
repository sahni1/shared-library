// src/com/example/Utility.groovy
package com.example

class Utility {
    // Method to log a message with timestamp
    def logWithTimestamp(String message) {
        echo "[${new Date()}] - ${message}"
    }

    // Method to add two numbers
    def addNumbers(int a, int b) {
        return a + b
    }
}
