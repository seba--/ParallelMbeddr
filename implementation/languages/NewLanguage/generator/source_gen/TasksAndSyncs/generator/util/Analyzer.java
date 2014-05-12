package TasksAndSyncs.generator.util;

/*Generated by MPS */

import org.jetbrains.mps.openapi.model.SNode;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SNodeOperations;
import jetbrains.mps.lang.smodel.generator.smodelAdapter.SLinkOperations;
import java.util.List;
import jetbrains.mps.internal.collections.runtime.ListSequence;
import java.util.Iterator;

public class Analyzer {


  public static boolean isLValue(SNode expression) {
    if (SNodeOperations.isInstanceOf(expression, "com.mbeddr.core.statements.structure.LocalVarRef") || SNodeOperations.isInstanceOf(expression, "com.mbeddr.core.modules.structure.GlobalVarRef") || SNodeOperations.isInstanceOf(expression, "com.mbeddr.core.pointers.structure.DerefExpr")) {
      return true;
    }
    {
      SNode referenceExpression = expression;
      if (SNodeOperations.isInstanceOf(referenceExpression, "com.mbeddr.core.pointers.structure.ReferenceExpr")) {
        return isLValue(SLinkOperations.getTarget(referenceExpression, "expression", true));
      }
    }
    {
      SNode genericDotExpression = expression;
      if (SNodeOperations.isInstanceOf(genericDotExpression, "com.mbeddr.core.expressions.structure.GenericDotExpression")) {
        return isLValue(SLinkOperations.getTarget(genericDotExpression, "expression", true));
      }
    }
    {
      SNode arrayAccessExpression = expression;
      if (SNodeOperations.isInstanceOf(arrayAccessExpression, "com.mbeddr.core.pointers.structure.ArrayAccessExpr")) {
        return isLValue(SLinkOperations.getTarget(arrayAccessExpression, "expression", true));
      }
    }
    return false;
  }




  /**
   * TODO: remove
   */
  public static boolean comesBefore(SNode node, SNode compareNode, SNode finalParentNode) {
    List<SNode> nodeAncestors = ListSequence.fromList(SNodeOperations.getAncestors(node, null, false)).subListSequence(0, ListSequence.fromList(SNodeOperations.getAncestors(node, null, false)).indexOf(finalParentNode));
    List<SNode> compareNodeAncestors = ListSequence.fromList(SNodeOperations.getAncestors(compareNode, null, false)).subListSequence(0, ListSequence.fromList(SNodeOperations.getAncestors(compareNode, null, false)).indexOf(finalParentNode));
    System.out.println("node size: " + ListSequence.fromList(nodeAncestors).count() + ", last: " + ListSequence.fromList(nodeAncestors).last() + ", first: " + ListSequence.fromList(nodeAncestors).first());
    System.out.println("cmpN size: " + ListSequence.fromList(compareNodeAncestors).count() + ", last: " + ListSequence.fromList(compareNodeAncestors).last() + ", first: " + ListSequence.fromList(compareNodeAncestors).first());
    System.out.println("=> LAST EQ?:" + (ListSequence.fromList(compareNodeAncestors).last() == ListSequence.fromList(nodeAncestors).last()));
    System.out.println("=> FIRST EQ?:" + (ListSequence.fromList(compareNodeAncestors).first() == ListSequence.fromList(nodeAncestors).first()));
    System.out.println("=> node anc:" + SNodeOperations.getAncestors(node, null, false));
    System.out.println("=> cpmN anc:" + SNodeOperations.getAncestors(compareNode, null, false));


    {
      Iterator<SNode> nodeAncestor_it = ListSequence.fromList(nodeAncestors).reversedList().iterator();
      Iterator<SNode> compareNodeAncestor_it = ListSequence.fromList(compareNodeAncestors).reversedList().iterator();
      SNode nodeAncestor_var;
      SNode compareNodeAncestor_var;
      while (nodeAncestor_it.hasNext() && compareNodeAncestor_it.hasNext()) {
        nodeAncestor_var = nodeAncestor_it.next();
        compareNodeAncestor_var = compareNodeAncestor_it.next();
        if (nodeAncestor_var != compareNodeAncestor_var) {
          if (ListSequence.fromList(SNodeOperations.getNextSiblings(nodeAncestor_var, false)).contains(compareNodeAncestor_var)) {
            return true;
          }
          return false;
        }
      }
    }
    // in the following tree + (node) and - (compareNode) shall be compared: 
    //    0 
    //  / | \ 
    // 0  +  x         => compare + and x instead (they are siblings since they are on the same level) 
    //      /|\ 
    //     0 0 - 
    SNode firstNode = node;
    SNode firstCompareNode = compareNode;
    if (ListSequence.fromList(nodeAncestors).count() > ListSequence.fromList(compareNodeAncestors).count()) {
      firstNode = ListSequence.fromList(SNodeOperations.getAncestors(node, null, false)).reversedList().getElement(ListSequence.fromList(compareNodeAncestors).count() - 1);
    } else if (ListSequence.fromList(nodeAncestors).count() < ListSequence.fromList(compareNodeAncestors).count()) {
      firstCompareNode = ListSequence.fromList(SNodeOperations.getAncestors(compareNode, null, false)).reversedList().getElement(ListSequence.fromList(nodeAncestors).count() - 1);
    }

    if (ListSequence.fromList(SNodeOperations.getNextSiblings(firstNode, false)).contains(firstCompareNode)) {
      return true;
    }
    return false;
  }
}
