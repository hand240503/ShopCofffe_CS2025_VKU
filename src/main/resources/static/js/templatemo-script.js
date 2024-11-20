/**
 * www.templatemo.com
 */

/* HTML document is loaded. DOM is ready.
-----------------------------------------*/
$(document).ready(function () {
    // Mobile menu
    $('.mobile-menu-icon').click(function () {
        $('.tm-nav').slideToggle();
    });

    $(window).resize(function () {
        if ($(window).width() > 767) {
            $('.tm-nav').show();
        } else {
            $('.tm-nav').hide();
        }
    });

    // http://stackoverflow.com/questions/2851663/how-do-i-simulate-a-hover-with-a-touch-in-touch-enabled-browsers
    $('body').on('touchstart', function () {
    });

    // Smooth scroll
    // https://css-tricks.com/snippets/jquery/smooth-scrolling/
    $('a[href*="#"]:not([href="#"])').click(function () {
        if (
            location.pathname.replace(/^\//, '') ==
            this.pathname.replace(/^\//, '') &&
            location.hostname == this.hostname
        ) {
            var target = $(this.hash);
            target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
            if (target.length) {
                $('html, body').animate(
                    {
                        scrollTop: target.offset().top,
                    },
                    1000
                );
                return false;
            }
        }
    });

    let quantity = parseInt($('.quantity-number').text());

    $('.quantity-btn.minus').click(function () {
        if (quantity > 1) {
            quantity--;
            $('.quantity-number').text(quantity);

            if (quantity === 1) {
                $(this).removeClass('yellow-btn');
                $(this).css('background-color', '#f0f0f0');
            } else {
                $(this).addClass('yellow-btn');
                $(this).css('background-color', '#ffa500');
            }
        } else {
            $(this).removeClass('yellow-btn');
            $(this).css('background-color', '#f0f0f0');
        }
    });

    $('.quantity-btn.plus').click(function () {
        quantity++;
        $('.quantity-number').text(quantity);

        if (quantity > 1) {
            $('.quantity-btn.minus').addClass('yellow-btn');
            $('.quantity-btn.minus').css('background-color', '#ffa500');
        } else {
            $('.quantity-btn.minus').removeClass('yellow-btn');
            $('.quantity-btn.minus').css('background-color', '#f0f0f0');
        }
    });

});

/* Window load event */
$(window).on('load', function () {
    // Remove preloader
    // https://ihatetomatoes.net/create-custom-preloading-screen/
    $('body').addClass('loaded');
});
