document.addEventListener('DOMContentLoaded', function () {
    const modal = document.querySelector('.modal');
    modal.style.display = 'none';
    const btnOrder = $('#btn-order');
    btnOrder.on('click', function () {
        let orderData = localStorage.getItem("order");
        if (orderData) {
            let order = JSON.parse(orderData);
            $('.address-input').val(order.address);
        }
        modal.style.display = 'flex';
    });

    modal.addEventListener('click', (e) => {
        if (e.target === modal) {
            modal.style.display = 'none';
        }
    });

    $("#save-btn").on("click", () => {
        let addressText = $('.address-input').val().trim();
        if (addressText) {
            let orderData = localStorage.getItem("order");

            if (orderData) {
                let order = JSON.parse(orderData);
                order.address = addressText;

                let productId = $("#product-id").val();
                let productName = $("#product-name").text();
                let productCode = $("#product-code").val();
                let productPrice = $("#product-price").val();
                let currentQuantity = parseInt($(".quantity-number").text(), 10);

                let existingItem = order.items.find(item => item.code === productCode);

                if (existingItem) {
                    existingItem.quantity += currentQuantity;
                } else {
                    let newItem = {
                        id: productId,
                        code: productCode,
                        name: productName,
                        quantity: currentQuantity,
                        price: productPrice
                    };
                    order.items.push(newItem);
                }

                order.totalPrice = order.items.reduce((total, item) => {
                    let itemPrice = parseFloat(item.price.replace('đ', '').replace(',', '').trim());
                    return total + (itemPrice * item.quantity);
                }, 0).toFixed(2);

                localStorage.setItem("order", JSON.stringify(order));
                modal.style.display = 'none';

            } else {
                let newOrder = {
                    address: addressText,
                    items: [],
                    totalPrice: 0.0
                };

                localStorage.setItem("order", JSON.stringify(newOrder));
            }
        }
    });







    $(".clear-button").on("click", () => {
        modal.style.display = 'none';
    });


});