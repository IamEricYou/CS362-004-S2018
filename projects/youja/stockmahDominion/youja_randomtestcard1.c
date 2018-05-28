//Smithy Card test
#include <stdio.h>
#include <math.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
#include <assert.h>
#include "dominion.h"
#include "dominion_helpers.h"
#include "rngs.h"

int testpass = 0;
int testfail = 0;

void test_smithy(int count);

int main(){
    srand(time(NULL));
    int i = 0;
    int count = 0;

    printf("Testing Smithy Card \n");
    for(i = 0; i < 5000; i++){
        test_smithy(count);
        count++;
    }

    printf("Total random test: %d, PASSED test: %d, FAILED test: %d \n", 5000,testpass,testfail);
    return 0;
}

void test_smithy(int count){
    struct gameState *state = newGame();
    struct gameState *testState = newGame();
    int k[10] = {adventurer, council_room, remodel, smithy, village, salvager, gardens, mine, ambassador, great_hall};
    int random_player = 2; //rand() % 4 + 2; //it should be fixed value to check only random value affacts to the fucntion of smithy card
    int random_card = rand() % 6; //random card will be passed btw 0-5
    int seed = 1000;
    int yourturn = 0;
    int check_result = 0;
    
    //I will check the 3 cards will be passed to players correctly.
    initializeGame(random_player,k,seed,state);
    //state->whoseTurn = random_player;

    memcpy(testState,state,sizeof(struct gameState));

    testState->hand[yourturn][testState->handCount[yourturn]] = smithy;
    testState->handCount[yourturn] = testState->handCount[yourturn] + 1;

    smithyCard(0,testState,0);

    check_result = state->handCount[yourturn] + random_card;
    //printf("Iteration: %d, Random Value: %d , Target value: %d \n", count, check_result, testState->handCount[yourturn]);
    
    if(check_result == testState->handCount[yourturn]){
        //printf("Test pass \n ");
        testpass = testpass + 1;
    }else{
        //printf("Test fail \n");
        testfail = testfail + 1;
    }
}