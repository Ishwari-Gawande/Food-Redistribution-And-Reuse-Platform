//using System.ComponentModel.DataAnnotations;

//namespace PaymentService.Entities
//{
//    public class Payment
//    {
//        [Key]
//        public int Id { get; set; }

//        public long DonorId { get; set; }

//        public long IndustryId { get; set; }

//        public decimal Amount { get; set; }

//        public string RazorpayOrderId { get; set; } = string.Empty;

//        public string? RazorpayPaymentId { get; set; }

//        public string Status { get; set; } = "CREATED";
//    }
//}


using System.ComponentModel.DataAnnotations;
using Microsoft.EntityFrameworkCore;

namespace PaymentService.Entities
{
    [Index(nameof(RazorpayOrderId), IsUnique = true)]
    [Index(nameof(RazorpayPaymentId), IsUnique = true)]
    public class Payment
    {
        [Key]
        public int Id { get; set; }

        [Range(1, long.MaxValue)]
        public long DonorId { get; set; }

        [Range(1, long.MaxValue)]
        public long IndustryId { get; set; }

        [Precision(12, 2)]
        public decimal Amount { get; set; }

        [Required]
        [MaxLength(100)]
        public string RazorpayOrderId { get; set; } = string.Empty;

        [MaxLength(100)]
        public string? RazorpayPaymentId { get; set; }

        [Required]
        [MaxLength(20)]
        public string Status { get; set; } = "CREATED";
    }
}
