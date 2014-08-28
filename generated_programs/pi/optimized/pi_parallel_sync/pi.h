#ifndef PI_H
#define PI_H


#include <stdint.h>

#include <stddef.h>

#include <stdbool.h>

#include "queue.h"

#include <stdio.h>

#include <sys/time.h>

#include "GenericTaskDeclarations.h"

#include "GenericSharedDeclarations.h"

#include "GenericSyncDeclarations.h"

#include <pthread.h>



#ifdef __cplusplus
extern "C" {
#endif

#define PI_BLOCKSIZE (60000)
#define PI_BLOCKCOUNT (2000)
#define PI_THRESHOLD (PI_BLOCKSIZE * PI_BLOCKCOUNT)
#define PI_PI (3.1415926535897932384626)
#define PI_MAPPERCOUNT (12)
int32_t pi_main(int32_t argc, char* argv[]);


#ifdef __cplusplus
} /* extern "C" */
#endif

#endif
