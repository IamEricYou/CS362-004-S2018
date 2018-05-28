#include <stdio.h>
#include <stdlib.h>
#include "dominion.h"
#include "dominion_helpers.h"


//test for int getCost(int cardNumber)

int comp_cost(int,int);

int main(int argc, char **argv) {

    printf("Test for some card cost in getCost function \n");
    //check 5 cards I choose.
    comp_cost(getCost(mine) , 5);
    comp_cost(getCost(village) , 3);
    comp_cost(getCost(smithy) , 4);
    comp_cost(getCost(adventurer) , 6);
    comp_cost(getCost(council_room) , 5);

    return 0;
}

int comp_cost(int real, int value) {
    if (real != value) {
        //print if the test is failed
        printf("TESTING FAILED IN THE COST FUNCTION. CHECK THE VALUE OF THE PROVIDED CARDS \n");
    } else {
        //print if the test is passed
        printf("TESTING PASSED IN THE COST FUNCTION \n");
    }
    return 0;
}