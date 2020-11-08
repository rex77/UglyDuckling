package com.ugdk.board.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ugdk.board.domain.BoardDTO;
import com.ugdk.board.mapper.BoardMapper;
import com.ugdk.board.paging.PaginationInfo;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardMapper boardMapper;

	@Override
	public boolean registerBoard(BoardDTO params) {
		int queryResult = 0;

		System.out.println("params.getIdx(): "+params.getIdx());
		if (params.getIdx() == null) {
			queryResult = boardMapper.insertBoard(params);
		} else {
			queryResult = boardMapper.updateBoard(params);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public BoardDTO getBoardDetail(Long idx) {
		return boardMapper.selectBoardDetail(idx);
	}

	@Override
	public boolean deleteBoard(Long idx) {
		int queryResult = 0;

		BoardDTO board = boardMapper.selectBoardDetail(idx);

		if (board != null && "N".equals(board.getDeleteYn())) {
			queryResult = boardMapper.deleteBoard(idx);
		}

		return (queryResult == 1) ? true : false;
	}

	@Override
	public List<BoardDTO> getBoardList(BoardDTO params) {
		List<BoardDTO> boardList = Collections.emptyList();

		int boardTotalCount = boardMapper.selectBoardTotalCount(params);

		PaginationInfo paginationInfo = new PaginationInfo(params);
		paginationInfo.setTotalRecordCount(boardTotalCount);

		params.setPaginationInfo(paginationInfo);

		if (boardTotalCount > 0) {
			boardList = boardMapper.selectBoardList(params);
		}

		return boardList;
	}
	
//	@Override
//	public List<BoardDTO> getPagedBoardList(int page) { //rexa original
//		List<BoardDTO> boardList = Collections.emptyList();
//
//		int boardTotalCount = boardMapper.selectBoardTotalCount();
//
//		//사용자 관점에서의 페이지를 보드 관점에서의 페이지로 바꾸어준다
//		boardList = boardMapper.selectPagedBoardList((page-1) * 10);
//		return boardList;
//	}

	@Override
	public int updateViewCount(Long idx) {
		BoardDTO board = boardMapper.selectBoardDetail(idx);
		System.out.println("updateviewcount1:" + board.getViewCnt());
		int count = board.getViewCnt() + 1;
		board.setViewCnt(count);
		System.out.println("updateviewcount2:" + board.getViewCnt());
		System.out.println("쿼리 결과 : " + boardMapper.updateBoard(board));
		return count;
	}
}
