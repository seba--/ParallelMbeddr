package TasksAndSyncs.editor;

/*Generated by MPS */

import jetbrains.mps.openapi.editor.descriptor.EditorAspectDescriptor;
import java.util.Collection;
import jetbrains.mps.openapi.editor.descriptor.ConceptEditor;
import jetbrains.mps.smodel.runtime.ConceptDescriptor;
import java.util.Arrays;
import java.util.Collections;
import jetbrains.mps.openapi.editor.descriptor.ConceptEditorComponent;
import jetbrains.mps.openapi.editor.descriptor.ConceptEditorHint;

public class EditorAspectDescriptorImpl implements EditorAspectDescriptor {
  public Collection<ConceptEditor> getEditors(ConceptDescriptor descriptor) {
    switch (Arrays.binarySearch(stringSwitchCases_xbvbvu_a0a0a, descriptor.getConceptFqName())) {
      case 0:
        return Collections.<ConceptEditor>singletonList(new ExprBoundToStruct_Editor());
      case 1:
        return Collections.<ConceptEditor>singletonList(new FutureContainer_Editor());
      case 2:
        return Collections.<ConceptEditor>singletonList(new FutureJoinContainer_Editor());
      case 3:
        return Collections.<ConceptEditor>singletonList(new FutureResultContainer_Editor());
      case 4:
        return Collections.<ConceptEditor>singletonList(new FutureType_Editor());
      case 5:
        return Collections.<ConceptEditor>singletonList(new SharedSet_Editor());
      case 6:
        return Collections.<ConceptEditor>singletonList(new SharedType_Editor());
      case 7:
        return Collections.<ConceptEditor>singletonList(new SyncRessource_Editor());
      case 8:
        return Collections.<ConceptEditor>singletonList(new SyncRessourceNamed_Editor());
      case 9:
        return Collections.<ConceptEditor>singletonList(new SyncRessourceRef_Editor());
      case 10:
        return Collections.<ConceptEditor>singletonList(new SyncStatement_Editor());
      case 11:
        return Collections.<ConceptEditor>singletonList(new Task_Editor());
      case 12:
        return Collections.<ConceptEditor>singletonList(new TaskType_Editor());
      default:
    }
    return Collections.emptyList();
  }

  public Collection<ConceptEditorComponent> getEditorComponents(ConceptDescriptor descriptor, String editorComponentId) {
    return Collections.emptyList();
  }



  public Collection<ConceptEditorHint> getHints() {
    return Collections.emptyList();
  }


  private static String[] stringSwitchCases_xbvbvu_a0a0a = new String[]{"TasksAndSyncs.structure.ExprBoundToStruct", "TasksAndSyncs.structure.FutureContainer", "TasksAndSyncs.structure.FutureJoinContainer", "TasksAndSyncs.structure.FutureResultContainer", "TasksAndSyncs.structure.FutureType", "TasksAndSyncs.structure.SharedSet", "TasksAndSyncs.structure.SharedType", "TasksAndSyncs.structure.SyncRessource", "TasksAndSyncs.structure.SyncRessourceNamed", "TasksAndSyncs.structure.SyncRessourceRef", "TasksAndSyncs.structure.SyncStatement", "TasksAndSyncs.structure.Task", "TasksAndSyncs.structure.TaskType"};
}
