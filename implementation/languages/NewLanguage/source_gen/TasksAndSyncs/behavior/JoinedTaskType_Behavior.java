package TasksAndSyncs.behavior;

/*Generated by MPS */

import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.smodel.behaviour.BehaviorReflection;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.internal.collections.runtime.ListSequence;

public class JoinedTaskType_Behavior {
  public static void init(SNode thisNode) {
  }

  public static int virtual_getUsedBytes_6941595764870551407(SNode thisNode) {
    return 0;
  }

  public static String virtual_getPresentation_1213877396640(SNode thisNode) {
    String presentation = "JoinedTask<" + BehaviorReflection.invokeVirtual(String.class, SLinkOperations.getTarget(thisNode, "returnType", true), "virtual_getPresentation_1213877396640", new Object[]{}) + "><";
    if (ListSequence.fromList(SLinkOperations.getTargets(thisNode, "argumentTypes", true)).count() > 0) {
      presentation += BehaviorReflection.invokeVirtual(String.class, ListSequence.fromList(SLinkOperations.getTargets(thisNode, "argumentTypes", true)).getElement(0), "virtual_getPresentation_1213877396640", new Object[]{});
      for (SNode argType : ListSequence.fromList(SLinkOperations.getTargets(thisNode, "argumentTypes", true)).tailListSequence(1)) {
        presentation += ", " + BehaviorReflection.invokeVirtual(String.class, argType, "virtual_getPresentation_1213877396640", new Object[]{});
      }
    }
    presentation += ">";
    return presentation;
  }
}
