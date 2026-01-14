package com.example

class Utility {
    def logWithTimestamp(String message) {
        echo "[${new Date()}] - ${message}"
    }

    def addNumbers(int a, int b) {
        return a + b
    }
}
