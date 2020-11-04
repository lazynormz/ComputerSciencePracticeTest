/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author pgn
 */
public class CarDealerShip
{

    private List<Car> carsForSale = new ArrayList<>();
    
    /**
     * Adds another car for sale but only if the value is not null, and only if
     * the car has a price greater than zero.
     *
     * @param car The car to add to list of cars for sale.
     */
    public void addCarForSale(Car car)
    {
        if(car != null)
            this.carsForSale.add(car);
    }
    
    /**
     * Gets the total value of all cars for sale.
     * @return the total value of all cars for sale.
     */
    public double getTotalCarValues()
    {
        double sum = 0;

        //Add up the sum of ALL cars into the variable named 'sum'
        for(Car car : carsForSale){
            sum += car.getPrice();
        }
        return sum;
    }
    
    /**
     * Gets the cheapest car from the list ov cars for sale.
     * @return the cheapest car from the list of cars for sale.
     */
    public Car getCheapestCar()
    {
        Car cheapestCar = carsForSale.get(0);

        //Look at every car that is available. If any of the cars' price are
        //lower than the current 'cheapestCar's price, that car is now the cheapest
        for(Car car : carsForSale) {
            if(cheapestCar.getPrice() > car.getPrice())
                cheapestCar = car;
        }
        return cheapestCar;
    }
    
    /**
     * Sells the car in the parameter - removes it from the list.
     *
     * @param car The car to be sold.
     */
    public void sellCar(Car car)
    {
        this.carsForSale.remove(car);
    }

    /**
     * Return the list containing the cars that the dealership has for sale
     *
     * @return List<car>
     */
    public List<Car> getCarsForSale()
    {
        return this.carsForSale;
    }
        
    /**
    * Sort the list of cars for sale in order from cheapest to most expensive
    */    
    public void sortCarsByPrice()
    {
        //Sorts the objects (o1, o2) on the value from getPrice(), and sorts on that
        carsForSale.sort((o1, o2) -> (int) (o1.getPrice() - o2.getPrice()));
    }
    
    /**
    * Sort the list of cars for sale in order from slowest to fastest.
    */    
    public void sortCarsByMaxSpeed()
    {
        //Lambda function for sorting. See @sortCarsByPrice for explanation on lambda
        carsForSale.sort(Comparator.comparingInt(Car::getMaxKilometersPerHour));
    }
    
    /**
     * Get a random car for sale.
     * @return a randomly selected car for sale.
     */
    public Car presentRandomCarToCustomer()
    {
        Random r = new Random();    //Used to generate random numbers.
        return carsForSale.get(r.nextInt(carsForSale.size()));
    }

}