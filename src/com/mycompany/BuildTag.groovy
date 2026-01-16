package com.mycompany

class BuildTag implements Serializable {
    def steps

    BuildTag(steps) {
        this.steps = steps
    }

    String generateTag(String branchName) {
        def date = new Date().format("yyyyMMddHHmm")
        return "${branchName}-${date}"
    }
}
