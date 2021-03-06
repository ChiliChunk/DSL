package nicoLang.aspects

import fr.inria.diverse.k3.al.annotationprocessor.Aspect
import nicoLang.FSM
import nicoLang.FinalState
import nicoLang.InitState
import nicoLang.NicoLangPackage
import nicoLang.State
import nicoLang.Transition
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl

import static extension nicoLang.aspects.FSMAspect.*
import java.util.Scanner

class Interpreter{
	def static void main (String [] args){
		NicoLangPackage.eINSTANCE.class
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put("xmi", new XMIResourceFactoryImpl)
		var Resource resource = new ResourceSetImpl().getResource(URI.createURI('/home/nicolas/Dev/workspace-gemoc-2/NicoLang/model/FSM.xmi'),true)
		var myfsm = resource.contents.get(0) as FSM
		myfsm.execute
	}
}



@Aspect(className=FSM)
class FSMAspect {
	 def void execute() {
	 	var Scanner sc = new Scanner (System.in)
		var currentState = getInitState(_self)
		var finalState = getFinalState(_self)
		println('Initial state : ' + currentState.name)
		var trigger = ""
		while (currentState.name != finalState.name) {
			trigger = sc.nextLine()
			var nextOne = findNext(_self, currentState, trigger)
			if(nextOne !== null){
				currentState = nextOne
			}
			println('State : ' + currentState.name)
		}
		println('Final State reached')
	}
	 
	 def State getInitState() {
		return _self.state.findFirst[s | s instanceof InitState]
	}
		
		
	def State getFinalState() {
		return _self.state.findFirst[s | s instanceof FinalState]
	}
	def State findNext(State current, String trigger){
		var transition =  _self.transition.findFirst[ t | t.source.name.equals(current.name) && t.trigger.equals(trigger)]
		if(transition !== null ){
			return transition.target
		}
		return null
	}	
}

@Aspect(className=State)
class StateAspect {

}

@Aspect(className=Transition)
class TransitionAspect {

}

@Aspect(className=InitState)
class InitStateAspect extends StateAspect {

}

@Aspect(className=FinalState)
class FinalStateAspect extends StateAspect {

}



