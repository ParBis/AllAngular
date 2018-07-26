import { LogService } from "./log.service";

describe('LogService', () => {
    
    it('this test case description', () => {
      expect(true).toBe(true);
    });
    let logService: LogService;

    beforeEach(function() {
      console.log('Before each test case...')
        logService = new LogService();
    });

    it('Pushing 2 messages in log service, should make size of logs as 2', ()=> {
        
       
        logService.log('Just a message to log');
        logService.log('Just a message to log');
        expect(logService.fetchLogs().length).toBe(2);
    })

    it('Fetch method with promises ', ()=> {

      // let logService: LogService = new LogService();
        logService.log('Just a message to log');
        logService.log('Just a message to log');
        logService.fetchLogsWithPromise().then((logs: Array<string>)=> {
          expect(logs.length).toBe(2)
        })

    })

  });