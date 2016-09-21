webpackJsonp([5], [function(a, t, i) {
    var e = i(1),
    n = (i(2), i(4)),
    r = i(13);
    e(function() {
        function a() {
            new r(u, {
                initialSlide: 0,
                pagination: ".swiper-pagination",
                autoplay: 5e3,
                speed: 200,
                touchMoveStopPropagation: !1,
                autoplayDisableOnInteraction: !1,
                onInit: function(a) {
                    u.css({
                        height: g / 720 * 420 + "px"
                    }),
                    u.find("img").css({
                        height: g / 720 * 420 + "px"
                    })
                },
                lazyLoading: !0
            })
        }

        var d = e(".index-page"),
        p = e("#city-list", d),
        u = e("#banner-box", d),
        g = document.body.clientWidth,
        w = i(11)
}]);