package TasksAndSyncs.behavior;

/*Generated by MPS */

import jetbrains.mps.baseLanguage.behavior.Expression_BehaviorDescriptor;
import com.mbeddr.core.expressions.behavior.IGenericDotTarget_BehaviorDescriptor;
import org.jetbrains.mps.openapi.model.SNode;
import com.mbeddr.core.expressions.behavior.IGenericDotTarget_Behavior;

public class Share_BehaviorDescriptor extends Expression_BehaviorDescriptor implements IGenericDotTarget_BehaviorDescriptor {
  public Share_BehaviorDescriptor() {
  }

  public SNode virtual_getTarget_7034214596260727602(SNode thisNode) {
    return Share_Behavior.virtual_getTarget_7034214596260727602(thisNode);
  }

  public boolean virtual_isLValue_6118219496712710630(SNode thisNode) {
    return IGenericDotTarget_Behavior.virtual_isLValue_6118219496712710630(thisNode);
  }

  public String virtual_renderReadable_8274105510415878941(SNode thisNode) {
    return IGenericDotTarget_Behavior.virtual_renderReadable_8274105510415878941(thisNode);
  }

  @Override
  public String getConceptFqName() {
    return "TasksAndSyncs.structure.Share";
  }
}
