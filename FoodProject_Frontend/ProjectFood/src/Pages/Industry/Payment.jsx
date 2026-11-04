// import { useState, useEffect } from "react";
// import { useLocation, useNavigate } from "react-router-dom";
// import { createOrder, verifyPayment as verifyPaymentApi } from "../../services/PaymentService";
// import "../../css/payment.css";

// const Payment = () => {
//     const location = useLocation();
//     const navigate = useNavigate();
//     const [loading, setLoading] = useState(false);
//     const [statusMessage, setStatusMessage] = useState("");

//     const paymentData = location.state || {
//         donorId: 1,
//         donorName: "Surplus Food Donor",
//         industryId: 1,
//         amount: 500,
//         requestId: 101
//     };

//     useEffect(() => {
//         // Load Razorpay checkout script if not already present
//         if (!window.Razorpay) {
//             const script = document.createElement("script");
//             script.src = "https://checkout.razorpay.com/v1/checkout.js";
//             script.async = true;
//             document.body.appendChild(script);
//         }
//     }, []);

//     const makePayment = async () => {
//         setLoading(true);
//         setStatusMessage("Initiating payment order...");
//         try {
//             let orderResponse;
//             try {
//                 orderResponse = await createOrder({
//                     donorId: paymentData.donorId,
//                     industryId: paymentData.industryId,
//                     amount: paymentData.amount
//                 });
//             } catch (err) {
//                 console.warn("Payment backend service unavailable, utilizing direct checkout flow:", err);
//                 orderResponse = {
//                     orderId: "order_demo_" + Date.now(),
//                     amount: paymentData.amount,
//                     key: "rzp_test_mockKey123"
//                 };
//             }

//             const options = {
//                 key: orderResponse.key || "rzp_test_mockKey123",
//                 amount: (orderResponse.amount || paymentData.amount) * 100,
//                 currency: "INR",
//                 name: "Beyond Waste",
//                 description: "Organic Waste Processing Contribution",
//                 order_id: orderResponse.orderId,
//                 prefill: {
//                     name: paymentData.donorName || "Beyond Waste Partner",
//                     email: paymentData.email || "partner@beyondwaste.org",
//                     contact: paymentData.phone || "9999999999"
//                 },
//                 notes: {
//                     donorId: paymentData.donorId,
//                     industryId: paymentData.industryId
//                 },
//                 handler: function (response) {
//                     handleVerifyPayment(response);
//                 },
//                 theme: {
//                     color: "#064e3b"
//                 }
//             };

//             if (window.Razorpay) {
//                 const razorpay = new window.Razorpay(options);
//                 razorpay.open();
//             } else {
//                 // Fallback simulation if checkout script is blocked
//                 alert("Simulating successful Razorpay payment transaction!");
//                 handleVerifyPayment({
//                     razorpay_order_id: orderResponse.orderId,
//                     razorpay_payment_id: "pay_mock_" + Date.now(),
//                     razorpay_signature: "sig_mock_" + Date.now()
//                 });
//             }
//         } catch (error) {
//             console.error("Payment Initialization Error:", error);
//             alert("Unable to start payment session.");
//         } finally {
//             setLoading(false);
//             setStatusMessage("");
//         }
//     };

//     const handleVerifyPayment = async (payment) => {
//         setStatusMessage("Verifying payment signature...");
//         try {
//             await verifyPaymentApi({
//                 orderId: payment.razorpay_order_id,
//                 paymentId: payment.razorpay_payment_id,
//                 signature: payment.razorpay_signature
//             });
//             alert("Payment Verified & Completed Successfully!");
//             navigate("/industry");
//         } catch (error) {
//             console.warn("Server verification fallback:", error);
//             alert("Payment Recorded & Verified Successfully!");
//             navigate("/industry");
//         }
//     };







//     return (

//         <div className="payment-page">


//             <div className="payment-header">


//                 <h2>
//                     🌱 Beyond Waste
//                 </h2>


//                 <span>
//                     Secure Payment
//                 </span>


//             </div>





//             <div className="payment-wrapper">



//                 <div className="payment-card">


//                     <h1>
//                         Pay Donor
//                     </h1>



//                     <p className="subtitle">

//                         Support sustainable food recovery

//                     </p>




//                     <div className="donor-box">


//                         <p>
//                             Donor
//                         </p>


//                         <h3>
//                             {paymentData.donorName}
//                         </h3>


//                     </div>





//                     <div className="amount-box">


//                         <span>
//                             Payment Amount
//                         </span>


//                         <h2>
//                             ₹{paymentData.amount}
//                         </h2>


//                     </div>





//                     <button

//                         className="pay-button"

//                         onClick={makePayment}

//                     >

//                         Proceed to Pay →

//                     </button>



//                 </div>





//                 <div className="impact-card">


//                     <div className="image-overlay">


//                         <h3>
//                             IMPACT METRIC
//                         </h3>


//                         <h1>
//                             Reduce Food Waste
//                         </h1>


//                         <p>
//                             Every contribution helps convert
//                             waste into renewable resources.
//                         </p>


//                     </div>


//                 </div>



//             </div>





//             <footer>

//                 © 2026 Beyond Waste · Privacy · Terms

//             </footer>



//         </div>

//     );

// };


// export default Payment;



import { useState, useEffect } from "react";
import { useLocation, useNavigate } from "react-router-dom";
import {
    createOrder,
    verifyPayment
} from "../../services/PaymentService";
import "../../css/payment.css";

const Payment = () => {
    const location = useLocation();
    const navigate = useNavigate();

    const paymentData = location.state;

    const [loading, setLoading] = useState(false);
    const [scriptReady, setScriptReady] = useState(
        typeof window !== "undefined" && !!window.Razorpay
    );
    const [statusMessage, setStatusMessage] = useState("");

    useEffect(() => {
        if (!paymentData) {
            return;
        }

        if (window.Razorpay) {
            setScriptReady(true);
            return;
        }

        const script = document.createElement("script");
        script.src = "https://checkout.razorpay.com/v1/checkout.js";
        script.async = true;

        script.onload = () => setScriptReady(true);
        script.onerror = () => {
            setScriptReady(false);
            setStatusMessage("Unable to load Razorpay checkout. Please try again.");
        };

        document.body.appendChild(script);

        return () => {
            script.onload = null;
            script.onerror = null;
        };
    }, [paymentData]);

    const handleVerifyPayment = async (response) => {
        setLoading(true);
        setStatusMessage("Verifying payment with the server...");

        try {
            const result = await verifyPayment({
                orderId: response.razorpay_order_id,
                paymentId: response.razorpay_payment_id,
                signature: response.razorpay_signature
            });

            if (result?.success !== true || result?.status !== "SUCCESS") {
                throw new Error("The server could not confirm this payment.");
            }

            alert("Payment verified successfully.");
            navigate("/industry");
        } catch (error) {
            console.error("Payment verification failed:", error);
            alert(
                "Payment verification failed. Do not retry immediately. " +
                "Please check your payment status or contact support."
            );
        } finally {
            setLoading(false);
            setStatusMessage("");
        }
    };

    const makePayment = async () => {
        if (!paymentData?.donorId ||
            !paymentData?.industryId ||
            !paymentData?.amount ||
            Number(paymentData.amount) <= 0) {
            alert("Payment details are missing or invalid.");
            return;
        }

        if (!window.Razorpay) {
            alert("Razorpay checkout is not available. Please try again.");
            return;
        }

        setLoading(true);
        setStatusMessage("Creating secure payment order...");

        try {
            const order = await createOrder({
                donorId: paymentData.donorId,
                industryId: paymentData.industryId,
                amount: Number(paymentData.amount)
            });

            if (!order?.orderId || !order?.key || !order?.amount) {
                throw new Error("Invalid order response from payment server.");
            }

            const options = {
                key: order.key,
                order_id: order.orderId,

                // Backend currently returns amount in rupees.
                // Razorpay Checkout expects paise.
                amount: Math.round(Number(order.amount) * 100),

                currency: order.currency || "INR",
                name: "Beyond Waste",
                description: "Organic Waste Processing Contribution",

                prefill: {
                    name: paymentData.donorName || "",
                    email: paymentData.email || "",
                    contact: paymentData.phone || ""
                },

                notes: {
                    donorId: String(paymentData.donorId),
                    industryId: String(paymentData.industryId)
                },

                handler: async (response) => {
                    await handleVerifyPayment(response);
                },

                modal: {
                    ondismiss: () => {
                        setLoading(false);
                        setStatusMessage("");
                    }
                },

                theme: {
                    color: "#064e3b"
                }
            };

            const razorpay = new window.Razorpay(options);

            razorpay.on("payment.failed", (response) => {
                console.error("Razorpay payment failed:", response.error);
                alert("Payment failed. Please try again.");
                setLoading(false);
                setStatusMessage("");
            });

            razorpay.open();
        } catch (error) {
            console.error("Payment initialization failed:", error);
            alert(
                error.response?.data?.message ||
                error.message ||
                "Unable to initiate payment."
            );
            setLoading(false);
            setStatusMessage("");
        }
    };

    if (!paymentData) {
        return (
            <div className="payment-page">
                <div className="payment-card">
                    <h2>Payment details unavailable</h2>
                    <p>Please return to the industry page and select a payment again.</p>
                    <button onClick={() => navigate("/industry")}>
                        Back to Industry
                    </button>
                </div>
            </div>
        );
    }

    return (
        <div className="payment-page">
            <div className="payment-header">
                <h2>🌱 Beyond Waste</h2>
                <span>Secure Payment</span>
            </div>

            <div className="payment-wrapper">
                <div className="payment-card">
                    <h1>Pay Donor</h1>

                    <p className="subtitle">
                        Support sustainable food recovery
                    </p>

                    <div className="donor-box">
                        <p>Donor</p>
                        <h3>{paymentData.donorName || "Food Donor"}</h3>
                    </div>

                    <div className="amount-box">
                        <span>Payment Amount</span>
                        <h2>₹{Number(paymentData.amount).toFixed(2)}</h2>
                    </div>

                    {statusMessage && <p>{statusMessage}</p>}

                    <button
                        className="pay-button"
                        onClick={makePayment}
                        disabled={loading || !scriptReady}
                    >
                        {loading
                            ? "Processing..."
                            : !scriptReady
                                ? "Loading Payment..."
                                : "Proceed to Pay →"}
                    </button>
                </div>

                <div className="impact-card">
                    <div className="image-overlay">
                        <h3>IMPACT METRIC</h3>
                        <h1>Reduce Food Waste</h1>
                        <p>
                            Every contribution helps convert
                            waste into renewable resources.
                        </p>
                    </div>
                </div>
            </div>

            <footer>
                © 2026 Beyond Waste · Privacy · Terms
            </footer>
        </div>
    );
};

export default Payment;
