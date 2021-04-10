<form action='/charge' method='POST' id='checkout-form' xmlns:th="http://www.w3.org/1999/xhtml">
    <input type='hidden' th:value='${amount/100}' name='amount'/>
    <h1>Price:<span th:text='${amount/100}'/></h1>
    <script
        src='https://checkout.stripe.com/checkout.js'
        className='stripe-button'
        th:attr='data-key=${pk_test_51IedCRDKgFH4TxsgPn0TasZDwT27QBq43ci2Jm5Wk0qnvMt374eLAwXjGgdZUHG02oeV4B3WAz27ANeZI7bujtRv007mDXZARH},
         data-amount=${1}'
        data-name='StackAbuse Services'
        data-description='Product Checkout'
        data-image
            ='http://www.stackabuse.com/assets/images/sa-java-dark.svg?v=b5a08453df'
        data-locale='auto'
        data-zip-code='false'>
    </script>
</form>