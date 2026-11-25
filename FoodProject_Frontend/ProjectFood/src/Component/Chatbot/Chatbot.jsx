import { useState } from "react";
import axios from "axios";
import "./Chatbot.css";

function Chatbot() {
  const [isOpen, setIsOpen] = useState(false);

  const [messages, setMessages] = useState([
    {
      sender: "bot",
      text: "Hi! 👋 Welcome to Beyond Waste. How can I help you today?",
    },
  ]);

  const [input, setInput] = useState("");
  const [loading, setLoading] = useState(false);

  const sendMessage = async (messageText) => {
    const message = messageText.trim();

    if (!message || loading) return;

    // Display the user's message
    setMessages((prev) => [
      ...prev,
      { sender: "user", text: message },
    ]);

    setInput("");
    setLoading(true);

    try {
      // Send message to Spring Boot backend
      const response = await axios.post(
        "http://localhost:8080/food/api/chat",
        {
          message: message,
        }
      );

      // Receive bot response
      setMessages((prev) => [
        ...prev,
        {
          sender: "bot",
          text: response.data.reply,
        },
      ]);
    } catch (error) {
      console.error("Chatbot error:", error);

      setMessages((prev) => [
        ...prev,
        {
          sender: "bot",
          text: "Sorry, I'm unable to connect right now. Please try again later.",
        },
      ]);
    } finally {
      setLoading(false);
    }
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    sendMessage(input);
  };

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
              <h3>Beyond Waste Assistant</h3>
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
          <div className="chatbot-messages">

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

            {loading && (
              <div className="chat-message bot">
                <div className="message-bubble">
                  Typing...
                </div>
              </div>
            )}
          </div>

          {/* Quick questions */}
          <div className="chatbot-quick-questions">
            <button
              onClick={() =>
                handleQuickQuestion("What is Beyond Waste?")
              }
            >
              About us
            </button>

            <button
              onClick={() =>
                handleQuickQuestion("How can I donate food?")
              }
            >
              Donate food
            </button>

            <button
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
              onChange={(e) => setInput(e.target.value)}
              disabled={loading}
            />

           
          </form>

        </div>
      )}
    </div>
  );
}

export default Chatbot;