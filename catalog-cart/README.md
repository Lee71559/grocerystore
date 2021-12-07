# Shan Shan Lee Journal - Items Catalog and Shopping Cart

## Journal 1 (10/28/21):
* Distributed tasks with team members, tasks are separated by frontend, backend, database, and office portal.
* Discussed the outline of the app including database schema, technologies used, and wepages to be designed. 
* Assigned to design database schema. 

## Journal 2 (10/28/21):
* Suggested to redistribute tasks, tasks are separated by functions including login/signup, catalog/cart, payment, backend office portal.
* Assigned to be responsible for items catalog and shopping cart.
* Started to create table, REST API for items, orders, and shopping cart.

## Journal 3 (11/11/21):
* Half-way done the backend for items catalog and shopping cart.
* Updated my progress with team members.

## Journal 4 (11/14/21)
* Discussed wbout every team members progress.
* Reported that no progress from me as it was midterm week.

## Journal 5 (11/18/21)
* Discussed with team members with the issue I was facing when debugging the REST API of shopping cart.
* Issue: Redundant orders made when customer adding different items into order table.
* Solution: Created another table to hold items for each order.
* Started implementing React for frontend.

## Journal 6 (11/20/21)
* Discussed with XueFeng about the updated table for order so that the issue is solved.
* Implemented React for frontend and continued working on it to make sure there is no bug.

## Journal 7 (11/28/21)
* Finalize my catalog and cart part and show my teammates.
* Discuss about deployment of React and backend to GKE.

## Journal 8 (12/2/21)
* Discuss about deployment of MySql, backend, React app to GKE.

## Journal 9 (12/6/21)
* Finzalize journal.

# Catalog-Cart
* React App as frontend
1. Catalog in frontend React app <br />
![catalog-frontend](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/catalog-frontend.png)

2. Catalog in database table <br />
![catalog-backend](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/catalog-backend.png)

3. Shopping cart in frontend React app <br />
![cart-frontend](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/cart-frontend.png)

4. Shopping cart in database table <br />
![cart-backend](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/cart-backend.png)

* Functions of the app
1. Adding Item into shopping cart <br />
Adding item from catalog <br />
![addItem-1](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/addItem-1.png)

Shopping cart is updated <br />
![addItem-2](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/addItem-2.png)

Database is updated <br />
![addItem-3](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/addItem-3.png)

2. Updating Item into shopping cart <br />
Updating item from shopping cart by adding or subtracting <br />
![updateItem-1](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/updateItem-1.png)

Shopping cart is updated <br />
![updateItem-2](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/updateItem-2.png)

Database is updated <br />
![updateItem-3](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/updateItem-3.png)

3. Deleting Item into shopping cart <br />
Deleting item from shopping cart <br />
![deleteItem-1](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/deleteItem-1.png)

Shopping cart is updated <br />
![deleteItem-2](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/deleteItem-2.png)

Database is updated <br />
![deleteItem-3](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/frontend/deleteItem-3.png)

* MySql as database 
1. Schema of database <br />
Schema for Mysql <br />
![mysql-schema](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/mysql-schema.png)

* API of springBoot app as backend
1. Get all items from itme table <br />
![api-getItem](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/api/api-getItem.png)

2. Get all items ordered by a customer <br />
![api-getOrderItem](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/api/api-getOrderItem.png)

3. Post an item to database, but this is excluded from frontend app since customers are not allowed to post item <br />
![api-postItem](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/api/api-postItem.png)

4. Post an item ordered by customer to their cart list <br />
![api-postOrderItem](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/api/api-postOrderItem.png)

5. Update an item quantity of customer shopping cart <br />
![api-putOrderitem](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/api/api-putOrderitem.png)

* Google cloud MySql deployment on GKE
1. A bucket is created for the frontend React app <br />
![bucket](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/mysql-images/bucket.png)

2. A google cloud MySql instance is created <br />
![instance](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/mysql-images/instance.png)

3. db-secret is created to connect to backend cluster <br />
![db-secret](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/mysql-images/db-secret.png)

4. Service accounts are created to link Mysql and backend GKE cluster <br />
![service-accounts](https://github.com/nguyensjsu/fa21-172-wing-chun/blob/main/catalog-cart/images/mysql-images/service-accounts.png)

# Getting Started with Create React App

This project was bootstrapped with [Create React App](https://github.com/facebook/create-react-app).

## Available Scripts

In the project directory, you can run:

### `npm start`

Runs the app in the development mode.\
Open [http://localhost:3000](http://localhost:3000) to view it in the browser.

The page will reload if you make edits.\
You will also see any lint errors in the console.

### `npm test`

Launches the test runner in the interactive watch mode.\
See the section about [running tests](https://facebook.github.io/create-react-app/docs/running-tests) for more information.

### `npm run build`

Builds the app for production to the `build` folder.\
It correctly bundles React in production mode and optimizes the build for the best performance.

The build is minified and the filenames include the hashes.\
Your app is ready to be deployed!

See the section about [deployment](https://facebook.github.io/create-react-app/docs/deployment) for more information.

### `npm run eject`

**Note: this is a one-way operation. Once you `eject`, you can’t go back!**

If you aren’t satisfied with the build tool and configuration choices, you can `eject` at any time. This command will remove the single build dependency from your project.

Instead, it will copy all the configuration files and the transitive dependencies (webpack, Babel, ESLint, etc) right into your project so you have full control over them. All of the commands except `eject` will still work, but they will point to the copied scripts so you can tweak them. At this point you’re on your own.

You don’t have to ever use `eject`. The curated feature set is suitable for small and middle deployments, and you shouldn’t feel obligated to use this feature. However we understand that this tool wouldn’t be useful if you couldn’t customize it when you are ready for it.

## Learn More

You can learn more in the [Create React App documentation](https://facebook.github.io/create-react-app/docs/getting-started).

To learn React, check out the [React documentation](https://reactjs.org/).

### Code Splitting

This section has moved here: [https://facebook.github.io/create-react-app/docs/code-splitting](https://facebook.github.io/create-react-app/docs/code-splitting)

### Analyzing the Bundle Size

This section has moved here: [https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size](https://facebook.github.io/create-react-app/docs/analyzing-the-bundle-size)

### Making a Progressive Web App

This section has moved here: [https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app](https://facebook.github.io/create-react-app/docs/making-a-progressive-web-app)

### Advanced Configuration

This section has moved here: [https://facebook.github.io/create-react-app/docs/advanced-configuration](https://facebook.github.io/create-react-app/docs/advanced-configuration)

### Deployment

This section has moved here: [https://facebook.github.io/create-react-app/docs/deployment](https://facebook.github.io/create-react-app/docs/deployment)

### `npm run build` fails to minify

This section has moved here: [https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify](https://facebook.github.io/create-react-app/docs/troubleshooting#npm-run-build-fails-to-minify)
