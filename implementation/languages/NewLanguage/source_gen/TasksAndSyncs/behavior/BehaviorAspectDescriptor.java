package TasksAndSyncs.behavior;

/*Generated by MPS */

import jetbrains.mps.smodel.runtime.BehaviorDescriptor;
import java.util.Arrays;
import jetbrains.mps.smodel.runtime.interpreted.BehaviorAspectInterpreted;

public class BehaviorAspectDescriptor implements jetbrains.mps.smodel.runtime.BehaviorAspectDescriptor {
  public BehaviorAspectDescriptor() {
  }

  public BehaviorDescriptor getDescriptor(String fqName) {
    switch (Arrays.binarySearch(stringSwitchCases_846f5o_a0a0b, fqName)) {
      case 4:
        return new Task_BehaviorDescriptor();
      case 2:
        return new RunningTask_BehaviorDescriptor();
      case 0:
        return new JoinedTask_BehaviorDescriptor();
      case 5:
        return new TaskType_BehaviorDescriptor();
      case 3:
        return new RunningTaskType_BehaviorDescriptor();
      case 1:
        return new JoinedTaskType_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }

  private static String[] stringSwitchCases_846f5o_a0a0b = new String[]{"TasksAndSyncs.structure.JoinedTask", "TasksAndSyncs.structure.JoinedTaskType", "TasksAndSyncs.structure.RunningTask", "TasksAndSyncs.structure.RunningTaskType", "TasksAndSyncs.structure.Task", "TasksAndSyncs.structure.TaskType"};
}
