ParallelMbeddr
==============

Master's thesis: *An extension of embedded C for parallel programming*

### Abstract
Multiprocessing is becoming steadily more important for raising the performance of computers. Par- allel programming is the key to leveraging such increased processing power. However, parallelization impedes the reasoning about side-effects of application code, which may cause data-races and, thus, non- deterministic behavior. Synchronization via locks is one measure to overcome this menace, by serializing conflicting parallel memory accesses. However, it can also impair an application’s run-time significantly. This thesis shows how mbeddr’s first-class language extension support and IDE integration can be used to partially overcome these issues for embedded software. The new language abstraction, ParallelMbeddr, offers convenient-to-use concepts for explicit parallelization. It provides a thread-safe communication approach by using the typesystem to prevent low-level data-races. Furthermore, it uses mbeddr’s com- piler integration to prototypically optimize the generated code in terms of synchronization overhead. The evaluation indicates that these goals are accomplished, although much potential for improvements and enhancements remains.
