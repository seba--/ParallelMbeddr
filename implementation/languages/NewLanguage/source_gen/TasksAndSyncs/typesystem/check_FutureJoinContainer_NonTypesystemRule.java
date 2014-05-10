package TasksAndSyncs.typesystem;

/*Generated by MPS */

import jetbrains.mps.lang.typesystem.runtime.AbstractNonTypesystemRule_Runtime;
import jetbrains.mps.lang.typesystem.runtime.NonTypesystemRule_Runtime;
import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.typesystem.inference.TypeCheckingContext;
import jetbrains.mps.lang.typesystem.runtime.IsApplicableStatus;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.typesystem.inference.TypeChecker;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import jetbrains.mps.errors.messageTargets.MessageTarget;
import jetbrains.mps.errors.messageTargets.NodeMessageTarget;
import jetbrains.mps.errors.IErrorReporter;
import jetbrains.mps.smodel.SModelUtil_new;

public class check_FutureJoinContainer_NonTypesystemRule extends AbstractNonTypesystemRule_Runtime implements NonTypesystemRule_Runtime {
  public check_FutureJoinContainer_NonTypesystemRule() {
  }

  public void applyRule(final SNode futureJoinContainer, final TypeCheckingContext typeCheckingContext, IsApplicableStatus status) {
    if (!(SNodeOperations.isInstanceOf(TypeChecker.getInstance().getTypeOf(SLinkOperations.getTarget(futureJoinContainer, "future", true)), "TasksAndSyncs.structure.FutureType"))) {
      {
        MessageTarget errorTarget = new NodeMessageTarget();
        IErrorReporter _reporter_2309309498 = typeCheckingContext.reportTypeError(SLinkOperations.getTarget(futureJoinContainer, "future", true), "only a future can be joined", "r:daf934de-3466-4fa8-a227-270fedb7e2f2(TasksAndSyncs.typesystem)", "5267241343316975639", null, errorTarget);
      }
    }
  }

  public String getApplicableConceptFQName() {
    return "TasksAndSyncs.structure.FutureJoinContainer";
  }

  public IsApplicableStatus isApplicableAndPattern(SNode argument) {
    {
      boolean b = SModelUtil_new.isAssignableConcept(argument.getConcept().getQualifiedName(), this.getApplicableConceptFQName());
      return new IsApplicableStatus(b, null);
    }
  }

  public boolean overrides() {
    return false;
  }
}