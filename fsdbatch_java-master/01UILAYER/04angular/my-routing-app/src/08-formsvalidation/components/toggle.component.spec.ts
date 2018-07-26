import { ToggleComponent } from "./toggle.component";

// import { LogService } from "./log.service";


describe('Toggle Component', () => {
  let component;
  beforeEach(function() {
    
    console.log('Before each test case...')
     component = new ToggleComponent();
  });


  it('initial value of toggle is false', () => {
    expect(component.flag).toBe(false)
  })

  it('on first click of button toggle should become true', () => {
    // let component = new ToggleComponent();
    component.clicked();
    expect(component.flag).toBe(true)
  })

  it('on first click of button toggle should become true', () => {
    let component = new ToggleComponent();
    component.clicked();
    component.clicked();
    expect(component.flag).toBe(false)
    expect(component.message).toBe('Toggle is false')
  })

});