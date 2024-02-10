/**
 * Date: 01/02/2024:00:07
 * User: shyamlal
 * Food Delivery and Review System
 * <p>
 * Use Cases
 * ● A platform hosting multiple Restaurants, each with its unique identifier, menu, pricing, and operating hours.
 * ● Each Restaurant can operate in multiple Locations with different delivery charges and taxes.
 * ● Customers from various Locations can place Orders containing multiple Dishes from Restaurants. The Order tracks the Dish details, quantities, price, taxes, payment details, and delivery detils(id,status,person).
 * ● Customers can also rate and review to a Restaurant and delivery person, and these ratings and reviews are visible to all Customers.
 * ● A loyalty and rewards program for Customers, with tracking of points earned.
 * <p>
 * Tables(cols)
 * <p>
 * <p>
 * Address - (adressId(PK),city,state,latitude,longitude)
 * <p>
 * resutauents -  restaurent_id(PK), name
 * <p>
 * resturant_store_mapping
 * - rest_store_id(PK),rest_id(FK),address_id,operating_hours, delevery_charges,
 * <p>
 * dishes - dish_id, dishtype, dishname, rest_store_id, price,
 * <p>
 * <p>
 * orders - order_id, customer_id, orderdetail_id, payment_id,price, taxes, and del_id(FK),status()
 * <p>
 * <p>
 * orderdetials - order_details_id,order_id, items_name,quantities
 * <p>
 * customer_adress_mapping
 * customer_id,addresId
 * <p>
 * customers - customer_id, customer_name, reward_points,
 * <p>
 * delivery
 * (del_id,del_persoon_id,phone,email)
 * <p>
 * payment_detials - payment_details_id, payment_id, upi/c/d/c,
 * <p>
 * <p>
 * rest_reviews - review_id, customr_id, resturent_id,order_id
 * <p>
 * Delivery_reviews - review_id, customr_id, delevery_person_id,
 * <p>
 * Loyalty(Loyalty_Id(PK),Customer_Id,Order_Id, Coins)
 */


/*** Resume Review
 * Developed a Java-based movie booking system with Spring Boot backend and Angular frontend.
 * Sravan Salaka
 * To: Everyone
 * 12:03 PM
 * Resolved concurrency issues for improved system performance and stability.
 * Sravan Salaka
 * To: Everyone
 * 12:03 PM
 * Added critical features like movie addition, user profiles, and booking functionality.
 * Sravan Salaka
 * To: Everyone
 * 12:33 PM
 * Designed and implemented a self-learning algorithm for a self-driving car and developed a robust Library Management System using machine learning techniques.
 */
public class SQL_Interview {
    public static void main(String[] args) {

    }

    public static void kl() {
    }
}
