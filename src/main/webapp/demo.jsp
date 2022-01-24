<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://kit.fontawesome.com/ae23c8822d.js" crossorigin="anonymous"></script>
    <style>
        .stars-outer {
  position: relative;
  display: inline-block;
}

.stars-inner {
  position: absolute;
  top: 0;
  left: 0;
  white-space: nowrap;
  overflow: hidden;
  width: 0;
}

.stars-outer::before {
  content: "\f005 \f005 \f005 \f005 \f005";
  font-family: "Font Awesome 5 Free";
  font-weight: 900;
  color: #ccc;
}

.stars-inner::before {
  content: "\f005 \f005 \f005 \f005 \f005";
  font-family: "Font Awesome 5 Free";
  font-weight: 900;
  color: #f8ce0b;
}





    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="form-group">
          <select id="product-select" class="form-control custom-select">
              <option value="0" disabled selected>Select Product</option>
              <option value="sony">Sony 4K TV</option>
              <option value="samsung">Samsung 4K TV</option>
              <option value="vizio">Vizio 4K TV</option>
              <option value="panasonic">Panasonic 4K TV</option>
              <option value="phillips">Phillips 4K TV</option>
            </select>
        </div>
        <div class="form-group">
          <input type="number" id="rating-control" class="form-control" step="0.1" max="5" placeholder="Rate 1 - 5" disabled>
        </div>
      
        <table class="table table-striped">
          <thead>
            <tr>
              <th>4K Television</th>
              <th>Rating</th>
            </tr>
          </thead>
          <tbody>
            <tr class="sony">
              <td>Sony 4K TV</td>
              <td>
                <div class="stars-outer">
                  <div class="stars-inner"></div>
                </div>
                <span class="number-rating"></span>
              </td>
            </tr>
            <tr class="samsung">
              <td>Samsung 4K TV</td>
              <td>
                <div class="stars-outer">
                  <div class="stars-inner"></div>
                </div>
                <span class="number-rating"></span>
              </td>
            </tr>
            <tr class="vizio">
              <td>Vizio 4K TV</td>
              <td>
                <div class="stars-outer">
                  <div class="stars-inner"></div>
                </div>
                <span class="number-rating"></span>
              </td>
            </tr>
            <tr class="panasonic">
              <td>Panasonic 4K TV</td>
              <td>
                <div class="stars-outer">
                  <div class="stars-inner"></div>
                </div>
                <span class="number-rating"></span>
              </td>
            </tr>
            <tr class="phillips">
              <td>Phillips 4K TV</td>
              <td>
                <div class="stars-outer">
                  <div class="stars-inner"></div>
                </div>
                <span class="number-rating"></span>
              </td>
            </tr>
          </tbody>
        </table>
      </div>
      <script>
      // Initial Ratings
    const ratings = {
      sony: 4.7,
      samsung: 3.4,
      vizio: 2.3,
      panasonic: 3.6,
      phillips: 4.1
    }
  console.log("hi");
    // Total Stars
    const starsTotal = 5;

    // Run getRatings when DOM loads
    document.addEventListener('DOMContentLoaded', getRatings);

    // Form Elements
    const productSelect = document.getElementById('product-select');
    const ratingControl = document.getElementById('rating-control');

    // Init product
    let product;

    // Product select change
    productSelect.addEventListener('change', (e) => {
      product = e.target.value;
      // Enable rating control
      ratingControl.disabled = false;
      ratingControl.value = ratings[product];
    });

    // Rating control change
    ratingControl.addEventListener('blur', (e) => {
      const rating = e.target.value;

      // Make sure 5 or under
      if (rating > 5) {
        alert('Please rate 1 - 5');
        return;
      }

      // Change rating
      ratings[product] = rating;

      getRatings();
    });

    // Get ratings
    function getRatings() {
      for (let rating in ratings) {
        // Get percentage
        const starPercentage = (ratings[rating] / starsTotal) * 100;

        // Round to nearest 10
        const starPercentageRounded = "${Math.round(starPercentage / 10) * 10}%";

        // Set width of stars-inner to percentage
        document.querySelector(" .stars-inner").style.width = starPercentageRounded;

        // Add number rating
        document.querySelector(" .number-rating").innerHTML = ratings[rating];
      }
    }
    </script>
</body>
</html>