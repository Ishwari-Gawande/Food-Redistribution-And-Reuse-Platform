//using Razorpay.Api;
//namespace PaymentService.Services

//{
//    public class RazorpayService : IRazorpayService
//    {
//        private readonly IConfiguration configuration;

//        public RazorpayService(IConfiguration configuration)
//        {
//            this.configuration = configuration;
//        }

//        public Order CreateOrder(decimal amount)
//        {
//            RazorpayClient client = new RazorpayClient(
//       configuration["Razorpay:KeyId"],
//       configuration["Razorpay:KeySecret"]);

//            var options = new Dictionary<string, object>
//{
//    { "amount", (int)(amount * 100) },
//    { "currency", "INR" },
//    { "receipt", Guid.NewGuid().ToString() }
//};

//            return client.Order.Create(options);
//        }
//    }
//}


using Razorpay.Api;

namespace PaymentService.Services
{
    public class RazorpayService : IRazorpayService
    {
        private readonly IConfiguration configuration;

        public RazorpayService(IConfiguration configuration)
        {
            this.configuration = configuration;
        }

        public Order CreateOrder(decimal amount)
        {
            var keyId = configuration["Razorpay:KeyId"];
            var keySecret = configuration["Razorpay:KeySecret"];

            if (string.IsNullOrWhiteSpace(keyId) ||
                string.IsNullOrWhiteSpace(keySecret))
            {
                throw new InvalidOperationException(
                    "Razorpay credentials are not configured.");
            }

            if (amount <= 0 ||
                amount * 100m != decimal.Truncate(amount * 100m) ||
                amount * 100m > int.MaxValue)
            {
                throw new ArgumentOutOfRangeException(
                    nameof(amount),
                    "Amount must be positive and valid in paise.");
            }

            var client = new RazorpayClient(keyId, keySecret);

            var options = new Dictionary<string, object>
            {
                { "amount", checked((int)(amount * 100m)) },
                { "currency", "INR" },
                { "receipt", Guid.NewGuid().ToString("N") }
            };

            return client.Order.Create(options);
        }
    }
}
