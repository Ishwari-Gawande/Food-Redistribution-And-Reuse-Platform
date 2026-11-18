//namespace PaymentService.Models
//{
//    public class PaymentResponse
//    {
//        public string OrderId { get; set; } = "";

//        public decimal Amount { get; set; }

//        public string Currency { get; set; } = "";

//        public string Key { get; set; } = "";
//    }
//}



using Microsoft.EntityFrameworkCore;

public async Task<bool> TryMarkSuccessAsync(
    string orderId,
    string paymentId)
{
    var affected = await context.Payments
        .Where(p =>
            p.RazorpayOrderId == orderId &&
            p.Status == "CREATED" &&
            p.RazorpayPaymentId == null)
        .ExecuteUpdateAsync(update => update
            .SetProperty(p => p.Status, "SUCCESS")
            .SetProperty(p => p.RazorpayPaymentId, paymentId));

    return affected == 1;
}
