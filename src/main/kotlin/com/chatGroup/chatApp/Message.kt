package com.chatGroup.chatApp

class Message {
    private var to: String = ""
    private var content: String = ""

    constructor() {

    }

    constructor(to: String, content: String) {
        this.to = to
        this.content = content
    }

    fun getTo(): String {
        return to
    }

    fun setTo(to: String) {
        this.to = to
    }

    fun getContent(): String {
        return content
    }

    fun setBody(content: String) {
        this.content = content
    }

    override fun toString(): String {
        return String.format("Message{to=%s, content=%s}", getTo(), getContent())
    }
}