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
      case 17:
        return new Task_BehaviorDescriptor();
      case 2:
        return new Future_BehaviorDescriptor();
      case 3:
        return new FutureJoin_BehaviorDescriptor();
      case 18:
        return new TaskType_BehaviorDescriptor();
      case 5:
        return new FutureType_BehaviorDescriptor();
      case 4:
        return new FutureResult_BehaviorDescriptor();
      case 1:
        return new ExprBoundToStruct_BehaviorDescriptor();
      case 0:
        return new CompoundLiteral_BehaviorDescriptor();
      case 9:
        return new SharedType_BehaviorDescriptor();
      case 7:
        return new SharedGet_BehaviorDescriptor();
      case 6:
        return new Share_BehaviorDescriptor();
      case 8:
        return new SharedSet_BehaviorDescriptor();
      case 10:
        return new SyncRessource_BehaviorDescriptor();
      case 15:
        return new SyncStatement_BehaviorDescriptor();
      case 11:
        return new SyncRessourceNamed_BehaviorDescriptor();
      case 12:
        return new SyncRessourceRef_BehaviorDescriptor();
      case 14:
        return new SyncStart_BehaviorDescriptor();
      case 16:
        return new SyncStop_BehaviorDescriptor();
      case 13:
        return new SyncRessourceRefByName_BehaviorDescriptor();
      default:
        return BehaviorAspectInterpreted.getInstance().getDescriptor(fqName);
    }
  }

  private static String[] stringSwitchCases_846f5o_a0a0b = new String[]{"TasksAndSyncs.structure.CompoundLiteral", "TasksAndSyncs.structure.ExprBoundToStruct", "TasksAndSyncs.structure.Future", "TasksAndSyncs.structure.FutureJoin", "TasksAndSyncs.structure.FutureResult", "TasksAndSyncs.structure.FutureType", "TasksAndSyncs.structure.Share", "TasksAndSyncs.structure.SharedGet", "TasksAndSyncs.structure.SharedSet", "TasksAndSyncs.structure.SharedType", "TasksAndSyncs.structure.SyncRessource", "TasksAndSyncs.structure.SyncRessourceNamed", "TasksAndSyncs.structure.SyncRessourceRef", "TasksAndSyncs.structure.SyncRessourceRefByName", "TasksAndSyncs.structure.SyncStart", "TasksAndSyncs.structure.SyncStatement", "TasksAndSyncs.structure.SyncStop", "TasksAndSyncs.structure.Task", "TasksAndSyncs.structure.TaskType"};
}
