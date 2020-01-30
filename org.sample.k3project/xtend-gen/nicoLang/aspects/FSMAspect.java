package nicoLang.aspects;

import com.google.common.base.Objects;
import fr.inria.diverse.k3.al.annotationprocessor.Aspect;
import java.util.Scanner;
import nicoLang.FSM;
import nicoLang.FinalState;
import nicoLang.InitState;
import nicoLang.State;
import nicoLang.Transition;
import nicoLang.aspects.FSMAspectFSMAspectProperties;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.InputOutput;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@Aspect(className = FSM.class)
@SuppressWarnings("all")
public class FSMAspect {
  public static void execute(final FSM _self) {
    final nicoLang.aspects.FSMAspectFSMAspectProperties _self_ = nicoLang.aspects.FSMAspectFSMAspectContext.getSelf(_self);
    // #DispatchPointCut_before# void execute()
    if (_self instanceof nicoLang.FSM){
    	nicoLang.aspects.FSMAspect._privk3_execute(_self_, (nicoLang.FSM)_self);
    };
  }
  
  public static State getInitState(final FSM _self) {
    final nicoLang.aspects.FSMAspectFSMAspectProperties _self_ = nicoLang.aspects.FSMAspectFSMAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# State getInitState()
    if (_self instanceof nicoLang.FSM){
    	result = nicoLang.aspects.FSMAspect._privk3_getInitState(_self_, (nicoLang.FSM)_self);
    };
    return (nicoLang.State)result;
  }
  
  public static State getFinalState(final FSM _self) {
    final nicoLang.aspects.FSMAspectFSMAspectProperties _self_ = nicoLang.aspects.FSMAspectFSMAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# State getFinalState()
    if (_self instanceof nicoLang.FSM){
    	result = nicoLang.aspects.FSMAspect._privk3_getFinalState(_self_, (nicoLang.FSM)_self);
    };
    return (nicoLang.State)result;
  }
  
  public static State findNext(final FSM _self, final State current, final String trigger) {
    final nicoLang.aspects.FSMAspectFSMAspectProperties _self_ = nicoLang.aspects.FSMAspectFSMAspectContext.getSelf(_self);
    Object result = null;
    // #DispatchPointCut_before# State findNext(State,String)
    if (_self instanceof nicoLang.FSM){
    	result = nicoLang.aspects.FSMAspect._privk3_findNext(_self_, (nicoLang.FSM)_self,current,trigger);
    };
    return (nicoLang.State)result;
  }
  
  protected static void _privk3_execute(final FSMAspectFSMAspectProperties _self_, final FSM _self) {
    Scanner sc = new Scanner(System.in);
    State currentState = FSMAspect.getInitState(_self);
    State finalState = FSMAspect.getFinalState(_self);
    String _name = currentState.getName();
    String _plus = ("Initial state : " + _name);
    InputOutput.<String>println(_plus);
    String trigger = "";
    while ((!Objects.equal(currentState.getName(), finalState.getName()))) {
      {
        trigger = sc.nextLine();
        State nextOne = FSMAspect.findNext(_self, currentState, trigger);
        if ((nextOne != null)) {
          currentState = nextOne;
        }
        String _name_1 = currentState.getName();
        String _plus_1 = ("State : " + _name_1);
        InputOutput.<String>println(_plus_1);
      }
    }
    InputOutput.<String>println("Final State reached");
  }
  
  protected static State _privk3_getInitState(final FSMAspectFSMAspectProperties _self_, final FSM _self) {
    final Function1<State, Boolean> _function = (State s) -> {
      return Boolean.valueOf((s instanceof InitState));
    };
    return IterableExtensions.<State>findFirst(_self.getState(), _function);
  }
  
  protected static State _privk3_getFinalState(final FSMAspectFSMAspectProperties _self_, final FSM _self) {
    final Function1<State, Boolean> _function = (State s) -> {
      return Boolean.valueOf((s instanceof FinalState));
    };
    return IterableExtensions.<State>findFirst(_self.getState(), _function);
  }
  
  protected static State _privk3_findNext(final FSMAspectFSMAspectProperties _self_, final FSM _self, final State current, final String trigger) {
    final Function1<Transition, Boolean> _function = (Transition t) -> {
      return Boolean.valueOf((t.getSource().getName().equals(current.getName()) && t.getTrigger().equals(trigger)));
    };
    Transition transition = IterableExtensions.<Transition>findFirst(_self.getTransition(), _function);
    if ((transition != null)) {
      return transition.getTarget();
    }
    return null;
  }
}
