package TasksAndSyncs.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractInequationReplacementRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.EquationInfo;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicable2Status;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.lang.typesystem.runtime.HUtil;
import java.util.Iterator;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.smodel.SModelUtil_new;

public class JoinedTaskType_subTypeOf_JoinedTaskType_InequationReplacementRule extends AbstractInequationReplacementRule_Runtime {
  public JoinedTaskType_subTypeOf_JoinedTaskType_InequationReplacementRule() {
  }

  public void processInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo, final TypeCheckingContext typeCheckingContext, IsApplicable2Status status, final boolean inequalityIsWeak, final boolean inequalityIsLessThan) {
    if (ListSequence.fromList(SLinkOperations.getTargets(subtype, "argumentTypes", true)).count() != ListSequence.fromList(SLinkOperations.getTargets(supertype, "argumentTypes", true)).count()) {
      {
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(equationInfo.getNodeWithError(), "differing argument numbers ", "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873212670142", null, errorTarget);
        HUtil.addAdditionalRuleIdsFromInfo(_reporter_2309309498, equationInfo);
      }
      return;
    }
    {
      SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
      EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873212670159", 0, null);
      _info_12389875345.getOuterRulesIdFromInfo(equationInfo);
      typeCheckingContext.createLessThanInequality((SNode) SLinkOperations.getTarget(subtype, "returnType", true), (SNode) SLinkOperations.getTarget(supertype, "returnType", true), false, true, _info_12389875345);
    }
    {
      Iterator<SNode> argTypeSub_it = ListSequence.fromList(SLinkOperations.getTargets(subtype, "argumentTypes", true)).iterator();
      Iterator<SNode> argTypeSuper_it = ListSequence.fromList(SLinkOperations.getTargets(supertype, "argumentTypes", true)).iterator();
      SNode argTypeSub_var;
      SNode argTypeSuper_var;
      while (argTypeSub_it.hasNext() && argTypeSuper_it.hasNext()) {
        argTypeSub_var = argTypeSub_it.next();
        argTypeSuper_var = argTypeSuper_it.next();
        {
          SNode _nodeToCheck_1029348928467 = equationInfo.getNodeWithError();
          EquationInfo _info_12389875345 = new EquationInfo(_nodeToCheck_1029348928467, null, "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "1304213873212670180", 0, null);
          _info_12389875345.getOuterRulesIdFromInfo(equationInfo);
          typeCheckingContext.createGreaterThanInequality((SNode) argTypeSub_var, (SNode) argTypeSuper_var, false, true, _info_12389875345);
        }
      }
    }
  }

  public boolean checkInequation(final SNode subtype, final SNode supertype, final EquationInfo equationInfo, IsApplicable2Status status, final boolean inequalityIsWeak, final boolean inequalityIsLessThan) {
    boolean result_14532009 = true;
    if (ListSequence.fromList(SLinkOperations.getTargets(subtype, "argumentTypes", true)).count() != ListSequence.fromList(SLinkOperations.getTargets(supertype, "argumentTypes", true)).count()) {
      result_14532009 = false;
      return result_14532009;
    }
    result_14532009 = result_14532009 && TypeChecker.getInstance().getSubtypingManager().isSubtype((SNode) SLinkOperations.getTarget(subtype, "returnType", true), (SNode) SLinkOperations.getTarget(supertype, "returnType", true), true);
    {
      Iterator<SNode> argTypeSub_it = ListSequence.fromList(SLinkOperations.getTargets(subtype, "argumentTypes", true)).iterator();
      Iterator<SNode> argTypeSuper_it = ListSequence.fromList(SLinkOperations.getTargets(supertype, "argumentTypes", true)).iterator();
      SNode argTypeSub_var;
      SNode argTypeSuper_var;
      while (argTypeSub_it.hasNext() && argTypeSuper_it.hasNext()) {
        argTypeSub_var = argTypeSub_it.next();
        argTypeSuper_var = argTypeSuper_it.next();
        result_14532009 = result_14532009 && TypeChecker.getInstance().getSubtypingManager().isSubtype((SNode) argTypeSuper_var, (SNode) argTypeSub_var, true);
      }
    }
    return result_14532009;
  }

  public boolean isWeak() {
    return true;
  }

  public IsApplicableStatus isApplicableSubtypeAndPattern(SNode node) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(node.getConcept().getQualifiedName(), this.getApplicableSubtypeConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public IsApplicableStatus isApplicableSupertypeAndPattern(SNode node) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(node.getConcept().getQualifiedName(), this.getApplicableSupertypeConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public String getApplicableSubtypeConceptFQName() {
    return "TasksAndSyncs.structure.JoinedTaskType";
  }

  public String getApplicableSupertypeConceptFQName() {
    return "TasksAndSyncs.structure.JoinedTaskType";
  }
}
