
import { useState, useEffect, useRef } from "react";
import axios from "axios";
import "./Chatbot.css";

function Chatbot() {
  const [isOpen, setIsOpen] = useState(false);

  const [messages, setMessages] = useState([
    {
      sender: "bot",
      text: "Hi! 👋 Welcome to Beyond Ways. How can I help you today?",
    },
  ]);

  const [input, setInput] = useState("");
  const [loading, setLoading] = useState(false);

  // Reference for automatic scrolling
  const messagesEndRef = useRef(null);

  // Automatically scroll to the latest message
  useEffect(() => {
    messagesEndRef.current?.scrollIntoView({
      behavior: "smooth",
    });
  }, [messages, loading]);

  // Send message to Spring Boot backend
  const sendMessage = async (messageText) => {
    const message = messageText.trim();

    if (!message || loading) return;

    if (message.length > 1000) {
      setMessages((prev) => [
        ...prev,
        {
          sender: "bot",
          text: "Please enter a message containing no more than 1000 characters.",
        },
      ]);
      return;
    }

    // Display user message
    setMessages((prev) => [
      ...prev,
      {
        sender: "user",
        text: message,
      },
    ]);

    setInput("");
    setLoading(true);

    try {
      const response = await axios.post(
        "http://localhost:8080/food/api/chat",
        {
          message: message,
        }
      );

      // Display chatbot response
      setMessages((prev) => [
        ...prev,
        {
          sender: "bot",
          text: response.data?.reply ||
            "Sorry, I couldn't generate a response. Please try again.",
        },
      ]);

    } catch (error) {
      console.error("Chatbot error:", error);

      setMessages((prev) => [
        ...prev,
        {
          sender: "bot",
          text: "Sorry, I'm unable to connect to the server right now. Please try again later.",
        },
      ]);

    } finally {
      setLoading(false);
    }
  };

  // Handle input submission
  const handleSubmit = (e) => {
    e.preventDefault();
    sendMessage(input);
  };

  // Handle quick questions
  const handleQuickQuestion = (question) => {
    sendMessage(question);
  };

  return (
    <div className="chatbot-container">

      {/* Floating chatbot button */}
      {!isOpen && (
        <button
          className="chatbot-toggle"
          onClick={() => setIsOpen(true)}
          aria-label="Open chatbot"
        >
          💬
        </button>
      )}

      {/* Chat window */}
      {isOpen && (
        <div className="chatbot-window">

          {/* Header */}
          <div className="chatbot-header">
            <div>
              <h3>Beyond Ways Assistant</h3>
              <span>● Online</span>
            </div>

            <button
              className="chatbot-close"
              onClick={() => setIsOpen(false)}
              aria-label="Close chatbot"
            >
              ✕
            </button>
          </div>

          {/* Messages */}
          <div
            className="chatbot-messages"
            aria-live="polite"
          >
            {messages.map((msg, index) => (
              <div
                key={index}
                className={`chat-message ${msg.sender}`}
              >
                <div className="message-bubble">
                  {msg.text}
                </div>
              </div>
            ))}

            {/* Typing indicator */}
            {loading && (
              <div className="chat-message bot">
                <div className="message-bubble">
                  Typing...
                </div>
              </div>
            )}

            {/* Auto-scroll reference */}
            <div ref={messagesEndRef} />
          </div>

          {/* Quick questions */}
          <div className="chatbot-quick-questions">

            <button
              type="button"
              disabled={loading}
              onClick={() =>
                handleQuickQuestion("What is Beyond Ways?")
              }
            >
              About us
            </button>

            <button
              type="button"
              disabled={loading}
              onClick={() =>
                handleQuickQuestion("How can I donate food?")
              }
            >
              Donate food
            </button>

            <button
              type="button"
              disabled={loading}
              onClick={() =>
                handleQuickQuestion("How can I request food?")
              }
            >
              Request food
            </button>

          </div>

          {/* Input form */}
          <form
            className="chatbot-input"
            onSubmit={handleSubmit}
          >
            <input
              type="text"
              placeholder="Type your message..."
              value={input}
              maxLength={1000}
              onChange={(e) => setInput(e.target.value)}
              disabled={loading}
            />

            <button
              type="submit"
              disabled={loading || !input.trim()}
              aria-label="Send message"
            >
              ➤
            </button>
          </form>

        </div>
      )}
    </div>
  );
}

export default Chatbot;
