#ifndef QUEUE_H
#define QUEUE_H


#include <stdint.h>

#include <stddef.h>

#include <stdbool.h>

#include "GenericTaskDeclarations.h"

#include "GenericSharedDeclarations.h"

#include "GenericSyncDeclarations.h"

#include "queue_SharedTypes_0.h"

#include <time.h>



#ifdef __cplusplus
extern "C" {
#endif

#define QUEUE_QUEUESIZE (10)
#define QUEUE_DELAY (50)
void queue_queueInit(queue_SharedTypes_0_SharedOf_Queue_0_t* queue);

void queue_queueSafeAdd(queue_SharedTypes_0_SharedOf_Queue_0_t* queue, long double item);

int32_t queue_queueGetInsertAt(queue_SharedTypes_0_SharedOf_Queue_0_t* queue);

void queue_queueSetInsertAt(queue_SharedTypes_0_SharedOf_Queue_0_t* queue, int32_t newInsertAt);

int32_t queue_queueGetDeleteAt(queue_SharedTypes_0_SharedOf_Queue_0_t* queue);

void queue_queueSetDeleteAt(queue_SharedTypes_0_SharedOf_Queue_0_t* queue, int32_t newDeleteAt);

long double queue_queueGetItemAt(queue_SharedTypes_0_SharedOf_Queue_0_t* queue, int32_t index);

void queue_queueSetItemAt(queue_SharedTypes_0_SharedOf_Queue_0_t* queue, int32_t index, long double newItem);

long double queue_queueGetLastAddedItem(queue_SharedTypes_0_SharedOf_Queue_0_t* queue);

void queue_queueSafeGet(queue_SharedTypes_0_SharedOf_Queue_0_t* queue, long double* result);


#ifdef __cplusplus
} /* extern "C" */
#endif

#endif